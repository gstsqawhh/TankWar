package message;

import model.GameModel;
import model.Role;

public class AttackTankMsg extends GameMsg{

	private int tankId;
	
	private Role role;
	
	public AttackTankMsg(GameModel gameModel, int tankId, Role role)
	{
		super(gameModel, MessageType.TANKATTACK);
		this.setTankId(tankId);
		this.role = role;
	}

	@Override
	public void execute()
	{
		
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getTankId() {
		return tankId;
	}

	public void setTankId(int tankId) {
		this.tankId = tankId;
	}
	
}
