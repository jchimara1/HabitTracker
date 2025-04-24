package swf.army.mil.habittracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


    @SpringBootTest
    @AutoConfigureMockMvc
    public class HabitTrackerControllerTest {


        @Mock
        HabitRepository habitRepository;

        @Autowired
        MockMvc mockMvc;


        @Mock
        HabitService hs = Mockito.mock(HabitService.class);


        Habit newHabit;
        Habit newHabit2;
        Habit saveHabit;
        List<Habit> listOfHabits;

        @BeforeEach
        void setUp() {
            newHabit = new Habit(1L, "test", "testing", 8, 8.9);
            saveHabit = new Habit(1L, "test", "testing", 8, 8.9);
            newHabit2 = new Habit(3L, "bike", "biking", 7, 7.9);
            listOfHabits = new ArrayList<>(List.of(newHabit, newHabit2));
            MockitoAnnotations.openMocks(this);
        }


        @Test
        void shouldAddHabitToDatabase(){
            Habit newHabit = new Habit(1L, "test", "testing", 8, 8.9);
            when(hs.createHabit(any(Habit.class)))
                    .thenReturn(newHabit);

            Habit result = hs.createHabit(new Habit(1L, "test", "testing", 8, 8.9));

            assertEquals("test", result.getTitle());



        }


}
