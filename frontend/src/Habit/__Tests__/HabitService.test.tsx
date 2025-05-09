// import { render, screen } from "@testing-library/react";
import { http, HttpResponse } from 'msw'
import { setupServer } from 'msw/node'

import { describe, it, expect } from "vitest";
// import axios from "axios";
import {HabitType} from "../../components/habitType.ts";
import {fetchHabits} from "../../components/HabitService.tsx";




describe('Habit Service', () => {




    const server = setupServer()
    beforeAll(() => server.listen({onUnhandledRequest: 'error'}))
    afterAll(() => server.close())
    afterEach(() => server.resetHandlers())

    it("this should fetch all habits from the habits database", async() => {
    const expected: HabitType[] = [{"id":1,"title":"Drink Water","description":"Drink at least 8 glasses a day","frequency":7,"mood":8.5},{"id":2,"title":"Exercise","description":"Workout 30 minutes","frequency":5,"mood":7.0},{"id":3,"title":"Read","description":"Read 10 pages of a book","frequency":3,"mood":9.0},{"id":4,"title":"Meditate","description":"Practice 10 minutes of mindfulness","frequency":4,"mood":8.0},{"id":5,"title":"Sleep Early","description":"Go to bed before 10 PM","frequency":6,"mood":9.5}];

    server.use(http.get('/api/habits', () =>
        HttpResponse.json(expected, {status: 201})



     ))
        expect(await fetchHabits()).toStrictEqual(expected);})}
)
