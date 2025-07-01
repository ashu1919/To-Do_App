import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {

    public static void main(String[] args) {

        
        JFrame frame = new JFrame("My To-Do List");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);

        // Top panel for input
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        // Bottom panel for delete button
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteButton);

        // Add task on button click
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        // Delete selected task
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index != -1) {
                    taskListModel.remove(index);
                }
            }
        });

       
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
