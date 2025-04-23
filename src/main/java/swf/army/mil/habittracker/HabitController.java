package swf.army.mil.habittracker;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
