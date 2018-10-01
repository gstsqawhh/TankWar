package model;

/**
 * StoneModel������Ϊ���࣬���������ڵ����Ϳ��Լ̳�������Ĭ������stoneType��speed��attackBloodOnce������
 * ��ȻҲ���Զ�ȡ�����ļ�����������Ļ�����д��������ĳ�ʼ�������У�Ҳ����д��ConstantsUtil�Ĺ̶������У�
 * 
 * ѡ��д��ConstantsUtil�Ĺ̶��������ƺ���һЩ�����Ը��õĸ���ֵ
 * 
 * @author whstar
 *
 */
public class StoneModel {
	
	private long stoneId;

	private long tankId;
	
	private ModelShapePosition modelPosition;
	
	private MoveDirection moveDirection;
	
	// �������Ը���stoneType���̶ֹ���ֵ
	private StoneType stoneType;
	
	private int attackBloodOnce;
	
	// ��ʾ�ӵ��ƶ����ٶȣ�ÿ��̹�˵��ٶȺ㶨����λ��x��λ/s����λ��������ϵ��Ϊ1�ĳ��ȣ���̹��������ϵ�е����Ϊ1*1��
	// Ȼ�����ӵ��������У���ÿ100ms�ƶ�һ�Σ�������ٶȿ��������ÿ���ƶ��ľ���Ϊx/10��λ���ȣ�
	private double stoneSpeed;
	
	public StoneModel(long stoneId)
	{
		this.setStoneId(stoneId);
	}
	
	public StoneModel(long stoneId, long tankId, ModelShapePosition modelPosition, MoveDirection direction)
	{
		this.stoneId = stoneId;
		this.tankId = tankId;
		this.modelPosition = modelPosition;
		this.moveDirection = direction;
	}

	/**
	 * ���ã����¶�Ӧstone��λ��
	 * 		�����ж϶�Ӧstone�Ƿ�������̹�ˣ���ҪGameModelȥ�ж�
	 * 
	 * �о�StoneController�ڴ���stone�ƶ�ʱ�����Ը����Լ���ʱ������stone������ٶȣ�
	 * ���һ��ʱ������stone�ƶ��ľ��룬Ȼ����ΪMsg����GameModel�Ĵ�������
	 * ��GameModel�ж��Ƿ��Ƿ����Ŀ��̹�˻����ϰ��Ȼ�������Ӧ�Ĳ�������֪ͨview����ʾ
	 */
	public void move(int distance)
	{
		modelPosition.move(moveDirection, distance);
	}
	
	public void destroy()
	{
		
	}
	
	public long getStoneId() {
		return stoneId;
	}

	public void setStoneId(long stoneId) {
		this.stoneId = stoneId;
	}

	public MoveDirection getMoveDirection() {
		return moveDirection;
	}

	public void setMoveDirection(MoveDirection moveDirection) {
		this.moveDirection = moveDirection;
	}

	public StoneType getStoneType() {
		return stoneType;
	}

	public void setStoneType(StoneType stoneType) {
		this.stoneType = stoneType;
	}

	public int getAttackBloodOnce() {
		return attackBloodOnce;
	}

	public void setAttackBloodOnce(int attackBloodOnce) {
		this.attackBloodOnce = attackBloodOnce;
	}

	public long getTankId() {
		return tankId;
	}

	public void setTankId(long tankId) {
		this.tankId = tankId;
	}

	public double getStoneSpeed() {
		return stoneSpeed;
	}

	public void setStoneSpeed(double stoneSpeed) {
		this.stoneSpeed = stoneSpeed;
	}

	public ModelShapePosition getModelPosition() {
		return modelPosition;
	}

	public void setModelPosition(ModelShapePosition modelPosition) {
		this.modelPosition = modelPosition;
	}

}
