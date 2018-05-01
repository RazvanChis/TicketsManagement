package view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class AdminMainView extends JDialog {

	private static final long serialVersionUID = 1L;

	private JButton usersButton;
	private JButton showsButton;

	public AdminMainView(Frame parentFrame) {
		super(parentFrame, "Admin Main View", true);
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.HORIZONTAL;

		usersButton = new JButton("Users");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		mainPanel.add(usersButton, constraints);

		showsButton = new JButton("Products");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		mainPanel.add(showsButton, constraints);

		usersButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				UsersView usersView = new UsersView(parentFrame);
				usersView.setVisible(true);
			}

		});
		
		//showsButton.addActionListener(new ActionListener(){

//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ProductsView productsView= new ProductsView(parentFrame);
//				productsView.setVisible(true);
//			}
//		});

		getContentPane().add(mainPanel, BorderLayout.CENTER);

		pack();
		setResizable(false);
		setLocationRelativeTo(parentFrame);
	}

}
