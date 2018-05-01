package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

import controller.UserDAOService;
import controller.UserDAOServiceImplementation;
import model.User;


public class UsersView extends JDialog {

	private static final long serialVersionUID = 1L;

	public UsersView(Frame parentFrame) {
		super(parentFrame, "UsersView", true);

		UserDAOService userDAOService = new UserDAOServiceImplementation();

		ArrayList<User> users = userDAOService.getAllUsers();
		UsersTableModel model = new UsersTableModel(users);
		JTable table = new JTable(model);
		model.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDAOService userDAOService = new UserDAOServiceImplementation();
				String cnp = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				userDAOService.deleteUser(cnp);
			}
		});

		model.updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UserDAOService userDAOService = new UserDAOServiceImplementation();
				String x = table.getModel().getValueAt(table.getSelectedRow(), 8).toString();
				User user = new User();
				user.setCnp(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				user.setFirstName(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
				user.setLastName(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
				user.setUsername(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
				if (table.getModel().getValueAt(table.getSelectedRow(), 4) != null) {
					user.setCardNumber(table.getModel().getValueAt(table.getSelectedRow(), 4).toString());
				}
				user.setEmail(table.getModel().getValueAt(table.getSelectedRow(), 5).toString());
				user.setCountry(table.getModel().getValueAt(table.getSelectedRow(), 6).toString());
				user.setCounty(table.getModel().getValueAt(table.getSelectedRow(), 7).toString());
				user.setCity(table.getModel().getValueAt(table.getSelectedRow(), 8).toString());
				user.setStreet(table.getModel().getValueAt(table.getSelectedRow(), 9).toString());
				user.setStreetNumber(table.getModel().getValueAt(table.getSelectedRow(), 10).toString());
				user.setType(table.getModel().getValueAt(table.getSelectedRow(), 11).toString());
				userDAOService.updateUser(user);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("Delete").setCellRenderer(buttonRenderer);
		table.getColumn("Update").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));

		final JButton addNewUserButton = new JButton("Add New User");
		addNewUserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddNewUserView addNewUserView = new AddNewUserView(parentFrame);
				addNewUserView.setVisible(true);
			}

		});

		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(addNewUserButton, BorderLayout.PAGE_END);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		pack();
		setVisible(true);

	}

	private static class JTableButtonRenderer implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JButton button = (JButton) value;
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(UIManager.getColor("Button.background"));
			}
			return button;
		}
	}

	private static class JTableButtonMouseListener extends MouseAdapter {
		private final JTable table;

		public JTableButtonMouseListener(JTable table) {
			this.table = table;
		}

		public void mouseClicked(MouseEvent e) {
			int column = table.getColumnModel().getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();

			if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
				Object value = table.getValueAt(row, column);
				if (value instanceof JButton) {
					((JButton) value).doClick();
				}
			}
		}
	}

}
