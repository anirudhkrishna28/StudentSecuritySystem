package teacher;

import watchman.WatchMan;

public class Teacher{
	 private String event;
	   private String attendance;

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

	private String intime,outtime;
	    private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;


	    public String getEvent() {
	        return event;
	    }

	    public void setEvent(String event) {
	        this.event = event;
	    }

	    public String getAttendance() {
	        return attendance;    
     }
	    public void setAttendance(String attendance) {
	        this.attendance = attendance;
	    }
}
