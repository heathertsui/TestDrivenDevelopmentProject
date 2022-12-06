package com.fdmgroup.tdd.groupcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GroupControllerServiceTest {

	@Mock
	DatabaseReader mockDatabaseReader;

	@Mock
	DatabaseWriter mockDatabaseWriter;

	public GroupController groupController;

	@BeforeEach
	void setup() {
		groupController = new GroupController(mockDatabaseReader, mockDatabaseWriter);
	}

	/**
	 * Test calls getAllTrainees which will return 0 when no trainees added as it is
	 * an empty map.
	 */
	@Test
	public void getAllTrainees_ReturnsEmptyTraineeMap_IfNoTraineesInMap() {
		assertEquals(0, groupController.getAllTrainees().size());
	}

	/**
	 * Test calls getAllTrainees which makes calls call to readGroup method in
	 * DatabaseReader via mock object. DatabaseReader is called once with no
	 * arguments.
	 * 
	 */
	@Test
	public void getAllTrainees_CallsReadGroupFromDatabaseReader_WhenCalled() {

		groupController.getAllTrainees();

		// mockDataBase reader called once through getAllTrainees method.
		verify(mockDatabaseReader, times(1)).readGroup();
	}

	@Test
	public void getAllTrainees_CallsReadGroupFromDatabaseReader_WhenCalledTwice() {

		groupController.getAllTrainees();
		groupController.getAllTrainees();

		// mockDataBase reader called once through getAllTrainees method.
		verify(mockDatabaseReader, times(2)).readGroup();
	}

	/**
	 * Test calls removeTraineeUserName which calls deleteTraineeByUsername method
	 * in DatabaseWriter via mock object. DatabaseWriter is called once with
	 * traineeUsername passed in as String argument.
	 */
	@Test
	public void removeTraineeByUsername_CallsDeleteTraineeByUserNameFromDatabaseWriter_WhenCalled() {
		// Creation of traineeUsername for test
		String traineeUsername = "chicken007";

		// passed as parameter to removeTraineeByUsername method
		groupController.removeTraineeByUsername(traineeUsername);
		verify(mockDatabaseWriter, times(1)).deleteTraineeByUsername(traineeUsername);

	}

	/**
	 * Test calls addTrainee which calls addTrainee method in DatabaseWriter via
	 * mock object. DatabaseWriter is called once with trainee object passed in as
	 * argument.
	 */
	@Test
	public void addTrainee_CallsAddTraineeFromDatabaseWriter_WhenCalledOnce() {
		// Creation of mock trainee object for test
		Trainee trainee = new Trainee();

		// Passed as parameter to addTrainee method in
		groupController.addTrainee(trainee);
		verify(mockDatabaseWriter, times(1)).addTrainee(trainee);
		;
	}

	@Test
	public void getAllTrainees_CallsReadGroupFromDatabaseReader_WhenCalledThreeTimes() {
		Trainee trainee = new Trainee();

		groupController.addTrainee(trainee);
		groupController.addTrainee(trainee);
		groupController.addTrainee(trainee);

		verify(mockDatabaseWriter, times(3)).addTrainee(trainee);
	}
}


