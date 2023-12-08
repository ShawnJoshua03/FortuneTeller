import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class FortuneTellerFrame extends JFrame {
    private JTextArea textArea;
    private ArrayList<String> fortunes;
    private int FortuneIndex = -1;
    public FortuneTellerFrame() {
        createComponents();
        setSizeRelativeToScreen();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("The Fortune Teller");
        setVisible(true);
    }
    private void createComponents() {
        fortunes = loadFortunes();
        ImageIcon icon = new ImageIcon("C:\\Users\\shawn\\IdeaProjects\\FT.jpeg");
        JLabel label = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        label.setFont(new Font("Garamond", Font.BOLD, 50));
        add(label, BorderLayout.NORTH);
        textArea = new JTextArea(10, 40);
        textArea.setFont(new Font("Garamond", Font.PLAIN, 20));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton fortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        buttonPanel.add(fortuneButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
        fortuneButton.addActionListener(e -> readFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void setSizeRelativeToScreen() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width * 2 / 4;
        int height = screenSize.height * 2 / 4;
        setSize(width, height);
        setLocationRelativeTo(null);
    }

    private ArrayList<String> loadFortunes() {
        ArrayList<String> fortunes = new ArrayList<>();
        fortunes.add("Beware of any fortune that ignores the bear in the room.");
        fortunes.add("You will soon have an unexpected encounter with a spoon.");
        fortunes.add("Your greatest fortune is the large number of friends you haven't met yet.");
        fortunes.add("Do not read any more fortunes - bad luck will fall upon those who are too curious!");
        fortunes.add("You will find a thing. It may be important.");
        fortunes.add("The fortune you seek is in another cookie.");
        fortunes.add("You will live long enough to open many fortune cookies.");
        fortunes.add("An alien of some sort will be appearing to you shortly.");
        fortunes.add("You will be hungry again in one hour.");
        fortunes.add("You will invent a new flavor of ice cream that baffles the human mind.");
        fortunes.add("You will cure short people");
        fortunes.add("Your next haircut will be an adventure.");
        return fortunes;
    }

    private void readFortune() {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == FortuneIndex);
        FortuneIndex = index;

        String fortune = fortunes.get(index);
        textArea.append(fortune + "\n");
    }
}
