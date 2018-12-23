import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//Generates a tabata workout: the exercises and number of rounds depending on how many exercises are generated


public class Tabata extends JFrame implements ActionListener{
	//Buttons
	JButton generate = new JButton("Generate");
	//JPanel
	JPanel p = new JPanel();
	//JList Stuff
	DefaultListModel data = new DefaultListModel();
	JList tabatalist = new JList(data);
	JScrollPane jsp = new JScrollPane(tabatalist);
	int r = 0;
	double initial = 30.0;
	double time = 0;
	
	//whatever number is generated, that is how many exercises will be picked from array
	//workout should total approximately 30 minutes
	//30 minutes / n exercises = anywhere from 3-6 rounds 
	//Display the exercises and total number of rounds
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creates frame of application
		Tabata app = new Tabata();
		app.setSize(500, 400);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setTitle("Tabata Generator");
		app.setVisible(true);
	}
	//Instantiate App
	Tabata(){
		add(p);
		p.add(jsp);
		p.add(generate);
		generate.addActionListener(this);
		jsp.setPreferredSize(new Dimension(400, 200));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Press Button
		if (e.getSource() == generate) {
			ExerciseGenerator(null);
			data.addElement("\n");
			data.addElement("\n" + "Number of Exercises: " + r);
			data.addElement("\n" + "Number of Cycles: " + AmtofTime(r));
			data.addElement("\n" + "Total Workout Time: " + (r * AmtofTime(r)) + " minutes");
		}
	}
	
	public String ExerciseGenerator (String[] exercises) {
		data.removeAllElements();
		int index = 0;
		//introduce array of Tabata Exercises
		String[] exercises1 = {"Box Jumps", "Pushups", "Back Lunges", "Rows", "Shoulder Press", "Diamond Pushups", "Shadow Boxing", 
				"Mountain Climbers", "Full Body Crunches", "Forward Lunges", "Side Lunges", "Skater Lunges", "Standing Bench Press",
				"Air Squats", "Plank", "Pistol Squats", "Scottie Jumps", "Burpees", "Thrusters", "Curls", "Side to Side Pushups", 
				"Duck Walk", "2-Hop Jumps"};
		//generate random integer between 5-10
		int min=5;
		int max=11;
		Random random = new Random();
		//store integer in variable
		r = random.nextInt(max-min)+min;
		//whatever number is generated, that is how many exercises will be picked from array
		int i = 0;
		System.out.println(r);
				while (i < r) {
					index = (int)(Math.random() * exercises1.length);
					data.addElement(exercises1[index]);
					i++;
				}
		return exercises1[index] ;
		
	}
	
	public int AmtofTime(int b) {
		time = initial / r;
		
		return (int) time;
		
	}

}

