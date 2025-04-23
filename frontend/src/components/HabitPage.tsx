import {useEffect, useState} from "react";
import {fetchHabits} from "./HabitService.tsx";
import {HabitType} from "./habitType.ts";

const HabitPage = () => {

    const [habit, setHabits] = useState<HabitType[]>([]);

    useEffect(() => {
        fetchHabits().then(setHabits).catch((err) => {
            console.error("Error loading todos:", err);
            alert("Failed to load todos.");
        });
    }, []);
    return (
        <div>
            <h2 role='heading'>Habit List</h2>
            <ul role='list'>
                {habit.map(user => (
                    <li role='listitem' key={user.id}>
                        <p>

                            {user.title}:  {user.description}
                        </p>
                        <p>
                            Mood:
                            {user.mood}
                        </p>

                    </li>
                ))}
            </ul>
        </div>
    );
};

export default HabitPage;