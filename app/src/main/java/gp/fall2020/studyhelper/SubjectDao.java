package gp.fall2020.studyhelper;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface SubjectDao {

    @Query("SELECT * FROM subjects ORDER BY text")
    public List<Subject> getSubjects();

    @Query("SELECT * FROM subjects ORDER BY updated DESC")
    public List<Subject> getSubjectsNewerFirst();

    @Query("SELECT * FROM subjects ORDER BY updated ASC")
    public List<Subject> getSubjectsOlderFirst();

    //added from zybooks questions
    @Query("SELECT * from subjects WHERE text = :text")
    public Subject getSubject(String text);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    public void insertSubject(Subject subject);

    @Update
    public void updateSubject(Subject subject);

    @Delete
    public void deleteSubject(Subject subject);
}
