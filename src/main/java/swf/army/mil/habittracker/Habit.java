package swf.army.mil.habittracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String description;
    private int frequency;
    private double mood;

    public Habit() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public double getMood() {
        return mood;
    }

    public void setMood(double mood) {
        this.mood = mood;
    }

    public Habit(Long id, String title, String description, int frequency, double mood) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.frequency = frequency;
        this.mood = mood;
    }
}
