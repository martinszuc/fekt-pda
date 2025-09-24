package tanks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import robocode.BattleResults;
import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
//import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

public class RobocodeRunner {

	public static void main(String[] args) throws IOException {

		String nazevTridyMehoRobota = "MujRobot";
		String seznamProtivniku = "TeamRobot1, TeamRobot2, TeamRobot3, TeamRobot4";
		
		// Week 1 Task 2: Alternative opponents for testing
		// String seznamProtivniku = "Crazy, Corners, Fire";
		
		// Week 1 Task 5: Test with custom robot
		// String nazevTridyMehoRobota = "MyTeamRobotNo1";

		runRobocode(nazevTridyMehoRobota, seznamProtivniku);
	}

	public static void runRobocode(String mujRobot, String seznamProtivniku) throws IOException {

		// create src and dest path for compiling
		String src = "src/sample/" + mujRobot + ".java";
		String dst = "robots/sample/" + mujRobot + ".java";
		// compile our created robot and store it to robots/samples
		File source = new File(src);
		File dest = new File(dst);
		Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, System.out, System.out, dst);
		// remove all whitespaces
		seznamProtivniku = seznamProtivniku.replaceAll("\\s", "");
		// create list of tanks to fight

		String tanks[] = seznamProtivniku.split(",");
		String finalListOfTanks = "";
		for (String string : tanks) {
			src = "src/sample/" + string + ".java";
			dst = "robots/sample/" + string + ".java";
			// compile our created robot and store it to robots/samples
			source = new File(src);
			dest = new File(dst);
			Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
			compiler.run(null, System.out, System.out, dst);
			
			string = "sample." + string + ",";
			finalListOfTanks += string;
		}

		finalListOfTanks += "sample." + mujRobot;

		// ("sample.Corners, sample.MujRobot"

		// Battle listener used for receiving battle events
		BattleObserver battleListener = new BattleObserver();

		// Create the RobocodeEngine
		RobocodeEngine engine = new RobocodeEngine(); // Run from current
														// working directory

		// Add battle listener to our RobocodeEngine
		engine.addBattleListener(battleListener);

		// Show the battles
		engine.setVisible(false);

		// Setup the battle specification

		int numberOfRounds = 25;
		BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600
		// RobotSpecification[] selectedRobots =
		// engine.getLocalRepository("sample.Corners, sample.MujRobot");
		RobotSpecification[] selectedRobots = engine.getLocalRepository(finalListOfTanks);

		BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);
		// Run our specified battle and let it run till it's over
		engine.runBattle(battleSpec, true/* wait till the battle is over */);

		// Display results with fitness function
		BattleResults[] results = battleListener.getResults();
		for (BattleResults result : results) {
			double fitness = calculateFitness(result, results);
			System.out.println(result.getTeamLeaderName() + " - Score: " + result.getScore() 
				+ " - Fitness: " + String.format("%.4f", fitness));
		}

		// Cleanup our RobocodeEngine
		engine.close();

		// Make sure that the Java VM is shut down properly
		System.exit(0);
	}
	
	/**
	 * Task 4: Fitness function implementation using softmax activation
	 * Calculates robot quality as value between 0.0 (worst) and 1.0 (best)
	 */
	public static double calculateFitness(BattleResults robot, BattleResults[] allResults) {
		// Find the maximum score for normalization
		double maxScore = 0;
		double totalExpScores = 0;
		
		// First pass: find max score and calculate total of exp scores
		for (BattleResults result : allResults) {
			if (result.getScore() > maxScore) {
				maxScore = result.getScore();
			}
		}
		
		// Second pass: calculate softmax denominator
		for (BattleResults result : allResults) {
			// Normalize scores to prevent overflow, then apply exp
			double normalizedScore = result.getScore() / (maxScore + 1); // +1 to avoid division by 0
			totalExpScores += Math.exp(normalizedScore);
		}
		
		// Calculate fitness using softmax activation function
		double normalizedScore = robot.getScore() / (maxScore + 1);
		double fitness = Math.exp(normalizedScore) / totalExpScores;
		
		return fitness;
	}
}