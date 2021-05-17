public class Actuator implements IActuator {

	@Override
	public void coolerOn() {
		System.out.println("Turned on the cooler! \n");
	}

	@Override
	public void coolerOff() {
		System.out.println("Turned off the cooler! \n");
	}

}