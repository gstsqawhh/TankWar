package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.GameController;

public class TankWarView extends JFrame implements ActionListener, Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameController gameController;
	
	public TankWarView(GameController controller)
	{
		this.setTitle("̹�˴�ս");
		this.setSize(1300, 700);
		this.setGameController(controller);
		
		// ��ӿ�ʼ��ս��ť
		JButton startGameButton = new JButton("��ʼ��ս");
//		startGameButton.setEnabled(true);
//		startGameButton.setBounds(650, 350, 50, 50);
		startGameButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				gameController.startGame();
			}
			
		});
		this.getRootPane().setDefaultButton(startGameButton);
		this.getContentPane().add(startGameButton);
		
	}
	
	
	
	
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public GameController getGameController() {
		return gameController;
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}

}
