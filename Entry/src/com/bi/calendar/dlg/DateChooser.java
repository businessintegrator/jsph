package com.bi.calendar.dlg;

import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.Dialog;
import java.awt.Point;
import java.awt.Window;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;

public class DateChooser  {

    private static final int _70 = 40;
    private JTable jtable = null;
    /**
     *
     */
    private static final long serialVersionUID = 6854539954934920795L;
    private boolean useHour = false;
    private final Dialog dc;

    public void setLocation(Point p) {
	dc.setLocation(p);
	
    }

    public void setLocationRelativeTo(Component component) {
	dc.setLocationRelativeTo(component);
    }
    
    public void setVisible(boolean b) {
	dc.setVisible(b);
    }

    public DateChooser(Window owner, JFormattedTextField formated) {
    this(owner,formated,false);
    
    }
    public DateChooser(Window owner, JFormattedTextField formated,boolean hour) {
	 JPanelDates datePanel = new JPanelDates(formated,hour);
	    ActDates actionlistener = new ActDates(datePanel);
	    DialogDescriptor dd = new DialogDescriptor(datePanel,
		    "Choisissez la date", true,
		    new Object[]{ActDates.Annuler, ActDates.Choisir}, ActDates.Choisir, 0, null, actionlistener);
	    this.dc = DialogDisplayer.getDefault().createDialog(dd);
	    actionlistener.setDlg(this.dc);
    }

    
  /*  private void initComponents(JFormattedTextField target) {
	Calendar cal = extractSellectedDate(target);
	int selectedMonth = cal.get(Calendar.MONTH) ;
	int selectedYear = cal.get(Calendar.YEAR);
	

	CalendarPopupModel model = new CalendarPopupModel();
	JDialog f = this;
	jtable = new JTable();
	jtable.setSelectionForeground(Color.BLUE);
	jtable.setForeground(Color.BLACK);
	jtable.setBorder(new BevelBorder(BevelBorder.LOWERED));
	JPanel north = new JPanel();
	JPanel south = new JPanel();
	north.setLayout(new FlowLayout());
	south.setLayout(new FlowLayout());
	JButton cancelButton = new JButton("Annuler");
	cancelButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		onCancel(arg0);

	    }
	});
	south.add(cancelButton);
	JButton okButton = new JButton("Ok");
	okButton.addActionListener(new Act(target, jtable, this));
	south.add(okButton);
	JComboBox<String> jcombomonth = new JComboBox<String>();
	ComboBoxModel<String> monthModel = new MonthModel();
	ItemListener monthItemstnr = new MonthLstnr(model);
	jcombomonth.addItemListener(monthItemstnr);
	jcombomonth.setModel(monthModel);
	JComboBox<String> jcomboyearth = new JComboBox<String>();
	ComboBoxModel<String> yearModel = new YearModel();
	ItemListener yearitemlstnr = new YearLstnr(model);
	jcomboyearth.addItemListener(yearitemlstnr);
	jcomboyearth.setModel(yearModel);
	jcomboyearth.setSelectedItem(""+selectedYear);
	jcombomonth.setSelectedIndex(selectedMonth);
	
	north.add(jcombomonth);
	north.add(jcomboyearth);
	f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	f.setLayout(new BorderLayout());
	f.add(north, BorderLayout.NORTH);
	f.add(south, BorderLayout.SOUTH);

	JScrollPane p = new JScrollPane();
	Dimension ddd = new Dimension(500, 400);

	p.setAutoscrolls(true);

	jtable.setSize(ddd);

	jtable.setRowHeight(_70);
	Dr d = new Dr();
	d.setMonthComponent(jcombomonth);
	d.setYearComponent(jcomboyearth);
	d.setSelectedDay(cal);
	jtable.setDefaultRenderer(D.class,d );

	jtable.setModel(model);
	//jtable.changeSelection(selectedDay/7, selectedDay%7, false, false);
	//jtable.addColumnSelectionInterval(selectedDay%7, selectedDay%7);
	//jtable.addRowSelectionInterval(selectedDay/7, selectedDay/7);
	
	p.getViewport().add(jtable);

	f.add(p, BorderLayout.CENTER);
	p.getViewport().setSize(ddd);
	f.setSize(ddd);
	f.setPreferredSize(ddd);
	f.pack();


    }

    private void onCancel(ActionEvent arg0) {
	dispose();
    }

    public void setUseHour(boolean b) {
	useHour = b;
    }

    public boolean isUseHour() {
	return useHour;
    }

    private Calendar extractSellectedDate(JFormattedTextField target) {
	// TODO Auto-generated method stub
	String txt = target.getText();
	Pattern pattern = Pattern.compile("\\d\\d.\\d\\d.\\d\\d\\d\\d [\\d\\d:\\d\\d]");
	Matcher m = pattern.matcher(txt);
	Calendar cal = Calendar.getInstance();
	if (txt != null && !"".equals(txt.trim()) && m.matches()) {
	    try {
		if (useHour){
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date d = f.parse(txt);
		cal.setTime(d);
		}else {
		    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date d = f.parse(txt);
		cal.setTime(d);
		}
		

	    } catch (ParseException ex) {
		Exceptions.printStackTrace(ex);
	    }

	}
	return cal;
    }*/
}
