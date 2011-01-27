class Teacher extends UserDecorator {
    public Class schoolClass;
	
	public Teacher(User u) {
		super(u);
	}
	
	public void addNoLunchDate(SimpleDate d) {
        schoolClass.noLunches.add(d);
	}
}
