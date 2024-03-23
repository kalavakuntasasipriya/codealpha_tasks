import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame 
{
    private JLabel titleLabel;
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounter() 
    {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("Enter your paragraph:");
        titleLabel.setBounds(20, 20, 150, 20);
        add(titleLabel);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 50, 350, 150);
        add(scrollPane);

        countButton = new JButton("Count Words");
        countButton.setBounds(150, 220, 120, 30);
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                countWords();
            }
        });
        add(countButton);

        resultLabel = new JLabel();
        resultLabel.setBounds(20, 260, 200, 20);
        add(resultLabel);

        setVisible(true);
    }

    private void countWords() 
    {
        String paragraph = textArea.getText();
        String[] words = paragraph.split("\\s+");
        int wordCount = words.length;
        resultLabel.setText("Word count: " + wordCount);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new WordCounter();
            }
        });
    }
}

