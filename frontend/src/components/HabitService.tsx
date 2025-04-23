
import {HabitType} from "./habitType.ts";
import axios, {AxiosResponse} from "axios";

type fetchHabit = () => Promise<HabitType[]>;
// type CreateHabit = (todo: { text: string; status: string }) => Promise<Todo>;




export const fetchHabits : fetchHabit =() => (
    axios.get('/api/habits')
        .then((r: AxiosResponse<HabitType[]>) => r.data)
)
