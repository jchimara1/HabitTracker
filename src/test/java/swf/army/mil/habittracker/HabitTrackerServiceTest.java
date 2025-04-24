package swf.army.mil.habittracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class HabitTrackerServiceTest {

    @Mock
    HabitRepository habitRepository;

    @InjectMocks
    HabitService hs;

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
    void shouldFetchHabits() {
        when(habitRepository.findAll()).thenReturn(listOfHabits);

        List<Habit> listOfRequests = hs.fetchHabits();
       // when(habitRepository.findAll()).thenReturn(listOfHabits);
        assertThat(listOfRequests).isEqualTo(listOfHabits);
    }

    @Test
    void ShouldCreateHabit() {
        when(habitRepository.save(newHabit)).thenReturn(saveHabit);
        Habit actualRequest = hs.createHabit(newHabit);
        verify(habitRepository, times(1)).save(any(Habit.class));
        assertThat(actualRequest).isEqualTo(saveHabit);
    }

    @Test
    void ShouldGetHabitById() {

        when(habitRepository.findById(1L)).thenReturn(Optional.ofNullable(listOfHabits.get(0)));
        Habit testHabit = hs.getHabitById(1L).orElse(null);
        verify(habitRepository, times(1)).findById(1L);
        assertThat(testHabit).isEqualTo(newHabit);



    }


    @Test
    void ShouldCreateAHabit(){
        Habit userHabit = new Habit(2L,"code", "code the backend of a website", 1, 8.4);
        int userID = Math.toIntExact(userHabit.getId());
        listOfHabits.add(userID , userHabit);


    }
}