import { render, screen } from "@testing-library/react";

import { describe, it, expect } from "vitest";

import HabitPage from "../../components/HabitPage.tsx";
import {fetchHabits} from "../../components/HabitService.tsx";
import {setupServer} from "msw/node";
import {HabitType} from "../../components/habitType.ts";
import {http, HttpResponse} from "msw";


describe('habit', ()=>{

    const server = setupServer()
    beforeAll(() => server.listen({onUnhandledRequest: 'error'}))
    afterAll(() => server.close())
    afterEach(() => server.resetHandlers())
    const expected: HabitType[] = [{"id":1,"title":"Drink Water","description":"Drink at least 8 glasses a day","frequency":7,"mood":8.5},{"id":2,"title":"Exercise","description":"Workout 30 minutes","frequency":5,"mood":7.0},{"id":3,"title":"Read","description":"Read 10 pages of a book","frequency":3,"mood":9.0},{"id":4,"title":"Meditate","description":"Practice 10 minutes of mindfulness","frequency":4,"mood":8.0},{"id":5,"title":"Sleep Early","description":"Go to bed before 10 PM","frequency":6,"mood":9.5}];

    server.use(http.get('/api/habits', () =>
        HttpResponse.json(expected, {status: 200})



    ))

    it("This should render the Habit Page", async() => {
        render(<HabitPage/>)
        const element = screen.getByRole('heading', { name: /Habit List/i });
        expect(element).toBeInTheDocument()
    })

    it("this should render a page and a list should be present on the page ", async() => {
        render(<HabitPage/>)
        expect(screen.getByRole("list"))
        expect(screen.getByRole("listitem"))
    })

    it("this should load habits from the database once the page loads", async() => {


        render(<HabitPage/>)
        const list = await screen.findByRole('list');
        const item = await screen.findAllByRole('listitem');

        expect(list).toBeInTheDocument();
        expect(item.length).toBeGreaterThan(0);
    })






})
