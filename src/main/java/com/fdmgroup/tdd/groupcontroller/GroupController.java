package com.fdmgroup.tdd.groupcontroller;

import java.util.Map;

public class GroupController implements GroupControllerService {

	private DatabaseReader databaseReader;
	private DatabaseWriter databaseWriter;

	// Injects mock objects into GroupController object via constructor
	public GroupController(DatabaseReader databaseReader, DatabaseWriter databaseWriter) {
		super();
		this.databaseReader = databaseReader;
		this.databaseWriter = databaseWriter;
	}

	// Mocks a map of trainee objects
	@Override
	public Map<String, Trainee> getAllTrainees() {
		return databaseReader.readGroup();
	}

	// passes trainee to addTrainee method of DatabaseWriter
	@Override
	public void addTrainee(Trainee trainee) {
		databaseWriter.addTrainee(trainee);
	}

	// method to removeTraineebyUsername by passing traineeUsername to
	// deleteTraineeByUsername method of DatabaseWriter
	@Override
	public void removeTraineeByUsername(String traineeUsername) {
		databaseWriter.deleteTraineeByUsername(traineeUsername);

	}

}
