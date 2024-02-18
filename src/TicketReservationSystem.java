import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketReservationSystem extends JFrame {

    private String username;

    public TicketReservationSystem() {
        showLoginPage();
        setTitle("Bookify");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    private void showLoginPage() {
        JPanel backgroundPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("C:\\Users\\Moon Khan\\Desktop\\istockphoto-1223350283-640x640.jpg").getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Bookify");
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        backgroundPanel.add(titleLabel, BorderLayout.NORTH);

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        inputPanel.add(new JLabel("Username: "), gbc);
        gbc.gridy++;
        inputPanel.add(usernameField, gbc);
        gbc.gridy++;
        inputPanel.add(new JLabel("Password: "), gbc);
        gbc.gridy++;
        inputPanel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(80, 25));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                char[] enteredPasswordChars = passwordField.getPassword();
                String enteredPassword = new String(enteredPasswordChars);

                if ("admin".equals(enteredUsername) && "admin".equals(enteredPassword)) {
                    username = enteredUsername;
                    showCategoriesPage();
                } else {
                    JOptionPane.showMessageDialog(TicketReservationSystem.this, "Incorrect username or password. Please try again.");
                }
            }
        });

        gbc.gridy++;
        inputPanel.add(loginButton, gbc);

        JLabel forgetPasswordLabel = new JLabel("Forgot Password?");
        forgetPasswordLabel.setForeground(Color.BLACK.darker());
        forgetPasswordLabel.setHorizontalAlignment(JLabel.RIGHT);
        forgetPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showResetPasswordDialog();
            }
        });

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridy++;
        inputPanel.add(forgetPasswordLabel, gbc);

        JLabel signUpLabel = new JLabel("<html><font color='black'>Don't have an account?</font> <font color='blue'>Sign up now!</font></html>");
        signUpLabel.setHorizontalAlignment(JLabel.LEFT);
        signUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showSignUpDialog();
            }
        });

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridy += 2;
        inputPanel.add(signUpLabel, gbc);

        backgroundPanel.add(inputPanel, BorderLayout.CENTER);

        add(backgroundPanel);
        revalidate();
        repaint();
    }
    private void showSignUpDialog() {
        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(new GridLayout(5, 2));

        JTextField nameField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JTextField newUsernameField = new JTextField(20);
        JPasswordField newPasswordField = new JPasswordField(20);
        JPasswordField confirmPasswordField = new JPasswordField(20);

        signUpPanel.add(new JLabel("Name: "));
        signUpPanel.add(nameField);
        signUpPanel.add(new JLabel("Email: "));
        signUpPanel.add(emailField);
        signUpPanel.add(new JLabel("New Username: "));
        signUpPanel.add(newUsernameField);
        signUpPanel.add(new JLabel("New Password: "));
        signUpPanel.add(newPasswordField);
        signUpPanel.add(new JLabel("Confirm Password: "));
        signUpPanel.add(confirmPasswordField);

        int result = JOptionPane.showConfirmDialog(this, signUpPanel, "Sign Up", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String email = emailField.getText();
            String newUsername = newUsernameField.getText();
            char[] newPasswordChars = newPasswordField.getPassword();
            char[] confirmPasswordChars = confirmPasswordField.getPassword();

            String newPassword = new String(newPasswordChars);
            String confirmPassword = new String(confirmPasswordChars);

            if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
            } else {
                JOptionPane.showMessageDialog(this, "New User Registered:\nName: " + name +
                        "\nEmail: " + email +
                        "\nUsername: " + newUsername +
                        "\nPassword: " + newPassword);
            }
        }
    }

    private void showResetPasswordDialog() {
        JPanel resetPasswordPanel = new JPanel();
        resetPasswordPanel.setLayout(new GridLayout(3, 2));

        JTextField usernameField = new JTextField(20);
        JPasswordField newPasswordField = new JPasswordField(20);
        JPasswordField confirmNewPasswordField = new JPasswordField(20);

        resetPasswordPanel.add(new JLabel("Username: "));
        resetPasswordPanel.add(usernameField);
        resetPasswordPanel.add(new JLabel("New Password: "));
        resetPasswordPanel.add(newPasswordField);
        resetPasswordPanel.add(new JLabel("Confirm New Password: "));
        resetPasswordPanel.add(confirmNewPasswordField);

        int result = JOptionPane.showConfirmDialog(this, resetPasswordPanel, "Reset Password", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String enteredUsername = usernameField.getText();
            char[] newPasswordChars = newPasswordField.getPassword();
            char[] confirmNewPasswordChars = confirmNewPasswordField.getPassword();

            String newPassword = new String(newPasswordChars);
            String confirmNewPassword = new String(confirmNewPasswordChars);

            if (!newPassword.equals(confirmNewPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
            } else {
                JOptionPane.showMessageDialog(this, "Password reset for user " + enteredUsername + " is successful.");
            }
        }
    }



    private void showCategoriesPage() {
        getContentPane().removeAll();
        revalidate();

        JButton busButton = new JButton("Bus");
        JButton flightButton = new JButton("Flight");
        JButton trainButton = new JButton("Train");
        JButton carButton = new JButton("Car Rentals");
        JButton cinemaButton = new JButton("Cinema");
        JButton eventsButton = new JButton("Events");

        busButton.addActionListener(e -> showDestinationPage("Bus"));
        flightButton.addActionListener(e -> showDestinationPage("Flight"));
        trainButton.addActionListener(e -> showDestinationPage("Train"));
        carButton.addActionListener(e -> showDestinationPage("Car"));
        cinemaButton.addActionListener(e -> showCinemaOptions());
        eventsButton.addActionListener(e -> showEventsOptions());

        Dimension buttonSize = new Dimension(120, 40);

        busButton.setPreferredSize(buttonSize);
        flightButton.setPreferredSize(buttonSize);
        trainButton.setPreferredSize(buttonSize);
        carButton.setPreferredSize(buttonSize);
        cinemaButton.setPreferredSize(buttonSize);
        eventsButton.setPreferredSize(buttonSize);

        add(busButton);
        add(flightButton);
        add(trainButton);
        add(carButton);
        add(cinemaButton);
        add(eventsButton);

        revalidate();
        repaint();
    }

    private void showDestinationPage(String category) {
        getContentPane().removeAll();
        revalidate();

        String[] cities = {"Karachi", "Lahore", "Islamabad", "Rawalpindi", "Multan", "Peshawar", "Abbottabad", "Sialkot", "Faisalabad", "Gujranwala"};

        JComboBox<String> fromComboBox = new JComboBox<>(cities);
        JComboBox<String> toComboBox = new JComboBox<>(cities);
        JButton okButton = new JButton("OK");

        okButton.addActionListener(e -> showDateSelectionPage(category, fromComboBox.getSelectedItem().toString(), toComboBox.getSelectedItem().toString()));

        add(new JLabel("From: "));
        add(fromComboBox);
        add(new JLabel("To: "));
        add(toComboBox);
        add(okButton);

        revalidate();
        repaint();
    }



    private void showDateSelectionPage(String category, String from, String to) {
        getContentPane().removeAll();
        revalidate();

        JComboBox<String> monthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        JComboBox<String> dayComboBox = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        JComboBox<String> yearComboBox = new JComboBox<>(new String[]{"2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"});
        JButton okButton = new JButton("OK");

        okButton.addActionListener(e -> showSeatSelectionPage(category, from, to,
                monthComboBox.getSelectedItem().toString(),
                dayComboBox.getSelectedItem().toString(),
                yearComboBox.getSelectedItem().toString()));

        add(new JLabel("Month: "));
        add(monthComboBox);
        add(new JLabel("Day: "));
        add(dayComboBox);
        add(new JLabel("Year: "));
        add(yearComboBox);
        add(okButton);

        revalidate();
        repaint();
    }

    private void showSeatSelectionPage(String category, String from, String to, String month, String day, String year) {
        getContentPane().removeAll();
        revalidate();

        JLabel seatLabel = new JLabel("Number of Seats: 0");
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton bookButton = new JButton("Book");

        int pricePerSeat = 750;
        int[] numberOfSeats = {0};
        JLabel fareLabel = new JLabel("Total Fare: Rs0");

        plusButton.addActionListener(e -> {
            numberOfSeats[0]++;
            updateFare(numberOfSeats[0], pricePerSeat, fareLabel);
            seatLabel.setText("Number of Seats: " + numberOfSeats[0]);
        });

        minusButton.addActionListener(e -> {
            if (numberOfSeats[0] > 0) {
                numberOfSeats[0]--;
                updateFare(numberOfSeats[0], pricePerSeat, fareLabel);
                seatLabel.setText("\nNumber of Seats: " + numberOfSeats[0]);
            }
        });

        bookButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Booking Confirmed!\nCategory: " + category + "\nFrom: " + from + "\nTo: " + to + "\nDate: " + month + " " + day + ", " + year + "\nSeats: " + numberOfSeats[0] + "\nTotal Fare: Rs" + calculateTotalFare(numberOfSeats[0], pricePerSeat) + "\nEnjoy your journey, " + username + "!");
            showCategoriesPage();
        });

        add(new JLabel("Category: " + category));
        add(new JLabel("From: " + from));
        add(new JLabel("To: " + to));
        add(new JLabel("Date: " + month + " " + day + ", " + year));
        add(seatLabel);
        add(minusButton);
        add(plusButton);
        add(fareLabel);
        add(bookButton);

        revalidate();
        repaint();
    }
    private void showCinemaOptions() {
        getContentPane().removeAll();
        setLayout(new GridLayout(2, 2, 5, 5));

        addCinemaButton("Oppenheimer", "Booking Confirmed! \n Category : Cinema \n Movie : Oppenheimer \n Seat: 1\n Price : 850 \n Enjoy Your Show ," + username + "!", "C:\\Users\\Moon Khan\\Downloads\\resize-170369651167004261906oppdmmobilebanner1080x745nowplf0107122364bab982784c71.jpg");
        addCinemaButton("Fight Club", "Booking Confirmed! \n Category : Cinema \n Movie :Fight Club \n Seat: 1\n Price : 850 \n Enjoy Your Show ," + username + "!", "C:\\Users\\Moon Khan\\Downloads\\resize-17036963821183445743images12.jpg");
        addCinemaButton("American Psycho", "Booking Confirmed! \n Category : Cinema \n Movie :American Psycho \n Seat: 1\n Price : 850 \n Enjoy Your Show ," + username + "!", "C:\\Users\\Moon Khan\\Downloads\\resize-17036967531915176416download17.jpg");
        addCinemaButton("Culpa Mia", "Booking Confirmed! \n Category : Cinema \n Movie : Culpa Mia \n Seat: 1\n Price : 850 \n Enjoy Your Show ," + username + "!", "C:\\Users\\Moon Khan\\Downloads\\resize-1703696813449998344download18.jpg");

        revalidate();
        repaint();
    }

    private void addCinemaButton(String title, String message, String imageName) {
        JButton cinemaButton = new JButton();
        cinemaButton.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(imageName);
        cinemaButton.setIcon(icon);

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        cinemaButton.add(titleLabel, BorderLayout.SOUTH);

        cinemaButton.addActionListener(e -> showMessage(message));

        add(cinemaButton);
    }
    
    private void showEventsOptions() {
        getContentPane().removeAll();
        setLayout(new GridLayout(2, 2, 10, 10)); 

        addEventButton("Young Stunners", "Booking Confirmed! \n Category : Event \n Concert : Young Stunners \n Seat: 1\n Price : 2000 \n Enjoy Your Show ," + username + "!", "C:\\Users\\Moon Khan\\Downloads\\resize-1703697930445471188download19.jpg");
        addEventButton("Qawali Night", "Booking Confirmed! \n Event : Qawalli Night \n Seat: 1\n Price : 1500 \n Enjoy Your Event ," + username + "!", "C:\\Users\\Moon Khan\\Downloads\\resize-17036982111298235028download21.jpg");
        addEventButton("Food Fest", "Booking Confirmed! \n Event : Food Festival \n Ticket: 1\n Price : 1800 \n Enjoy Your event ," + username + "!", "C:\\Users\\Moon Khan\\Downloads\\resize-1703698359204023055download22.jpg");
        addEventButton("New Year Event", "Booking Confirmed! \n Event : New Year Party \n Ticket: 1\n Price : 3000 \n Enjoy Your Show ," + username + "!", "C:\\Users\\Moon Khan\\Downloads\\resize-1703698572435894057download23.jpg");

        revalidate();
        repaint();
    }

    private void addEventButton(String title, String message, String imageName) {
        JButton eventButton = new JButton();
        eventButton.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(imageName);
        eventButton.setIcon(icon);

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        eventButton.add(titleLabel, BorderLayout.SOUTH);

        eventButton.addActionListener(e -> showMessage(message));

        add(eventButton);
    }
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void addButton(String label, String actionCommand) {
        JButton button = new JButton(label);
        button.setActionCommand(actionCommand);
        button.addActionListener(e -> {
            String command = e.getActionCommand();
            JOptionPane.showMessageDialog(this, "" + " " + command);
        });
        add(button);
    }

    private void updateFare(int numberOfSeats, int pricePerSeat, JLabel fareLabel) {
        int totalFare = numberOfSeats * pricePerSeat;
        fareLabel.setText("Total Fare: RS " + totalFare);
    }

    private int calculateTotalFare(int numberOfSeats, int pricePerSeat) {
        return numberOfSeats * pricePerSeat;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketReservationSystem());
    }
}