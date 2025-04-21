package swf.army.mil.habittracker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> fetchHabits() {
        List<Habit> list = habitRepository.findAll();
        System.out.println(" Habit Service returned " + list.size() + " Habit");
        return list;
    }

    public Habit createHabit(Habit newTodo) {
        return habitRepository.save(newTodo);
    }
}
