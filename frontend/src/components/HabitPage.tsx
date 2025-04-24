import {useEffect, useState} from "react";
import {fetchHabits} from "./HabitService.tsx";
import {HabitType} from "./habitType.ts";

const HabitPage = () => {

    const [Habit, setHabits] = useState<HabitType[]>([]);
    const [newHabit, setNewHabit] = useState<Omit<HabitType, "id">>({
        title: "",
        description: "",
        frequency: 0,
        mood: 0.0
    });

    useEffect(() => {
        fetchHabits().then(setHabits).catch((err) => {
            console.error("Error loading todos:", err);
            alert("Failed to load todos.");
        });
    }, []);

    const onClick = (event: React.FormEvent) => {
        event.preventDefault();

        const newHabitWithId: HabitType = { ...newHabit, id: new Date().getTime() };

        setHabits([...Habit, newHabitWithId]);

        setNewHabit({         title: "",
            description: "",
            frequency: 0,
            mood: 0.0 });
    }

    const onChange = (event: React.ChangeEvent<HTMLInputElement> ) => {
        const { name, value } = event.target;
        setNewHabit({
            ...newHabit,
            [name]: name === "frequency" ? parseInt(value) : value,
            [name]: name === "mood" ? parseFloat(value) : value,
        });
        console.log(name,value)
    }

    return (
        <div>
            <h2 role='heading'>Habit List</h2>
            <form onSubmit={onClick}>
                <label>Title:
                <input role='textbox' name='title' placeholder='title' value={newHabit.title} onChange={onChange}/>
                </label>
                <br/>
                <label>Description:
                    <input role='textbox' name='description' placeholder='description' value={newHabit.description} onChange={onChange}/>
                </label>
                <br/>
                <label>Frequency:
                    <input role='textbox' name='frequency' type='number'  placeholder='frequency' value={newHabit.frequency} onChange={onChange}/>
                </label>
                <br/>
                <label>Mood:
                    <input role='textbox' type='number' name='mood' placeholder='mood' value={newHabit.mood} onChange={onChange}/>
                </label>
                <button role="button" name='submit' >submit</button>
            </form>
            <ul role='list'>
                {Habit.map(user => (
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