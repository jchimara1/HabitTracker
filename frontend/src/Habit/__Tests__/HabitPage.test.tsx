import { render, screen } from "@testing-library/react";

import { describe, it, expect } from "vitest";

import HabitPage from "../components/HabitPage.tsx";


describe('habit', ()=>{

    it("This should render the Habit Page", async() => {
        render(<HabitPage/>)
        expect(screen.getByRole("heading", { name: "Habit List" })).toBeVisible()
    })
})
