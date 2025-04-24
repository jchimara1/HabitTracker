package swf.army.mil.habittracker;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
@CrossOrigin(origins = "http://localhost:8080")
public class HabitController {

    private final HabitService habitService;


    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }


    @GetMapping
    public ResponseEntity<List<Habit>> getAllHabits(){
        List<Habit> habits = habitService.fetchHabits();
        return ResponseEntity.ok(habits);
    }

    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody Habit newHabit){
        Habit savedHabit = habitService.createHabit(newHabit);
        return ResponseEntity.ok(savedHabit);
    }
}
