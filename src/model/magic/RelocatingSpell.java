package harrypotter.model.magic;

public class RelocatingSpell extends Spell {

	private int range;

	public RelocatingSpell(String name, int cost, int coolDown, int range) {

		super(name, cost, coolDown);
		this.range = range;

	}

	public RelocatingSpell(RelocatingSpell s){
		this(s.getName(),s.getCost(), s.getDefaultCooldown(), s.range);
	}
	public int getRange() {
		return range;
	}
}
