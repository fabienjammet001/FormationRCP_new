package com.sogeti.rental.ui.views;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;
import org.eclipse.swt.layout.FillLayout;

public class RentalPropertyView extends ViewPart {

	private Label rentedObjetLabel;
	private Label customerLabel;
	private Label beginDate;
	private Label endDate;

	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		// TODO Auto-generated method stub
		
		
		Group infoGroup = new Group( parent, SWT.NONE);
		infoGroup.setText("INFORMATIONS");
		infoGroup.setLayout(new GridLayout(2,false));
		
		rentedObjetLabel = new Label(infoGroup, SWT.NONE);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjetLabel.setLayoutData ( gd) ;
		
		Label lblNewLabel_1 = new Label(infoGroup, SWT.NONE);
		lblNewLabel_1.setText("Lou\u00E9 \u00E0 : ");
		
		customerLabel = new Label(infoGroup, SWT.NONE);
		customerLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		customerLabel.setText("John Wayne");
		
		Group grpDatesDeLoacation = new Group(parent, SWT.NONE);
		grpDatesDeLoacation.setText("Dates de location");
		grpDatesDeLoacation.setLayout(new GridLayout(2, false));
		
		Label lblDu = new Label(grpDatesDeLoacation, SWT.NONE);
		lblDu.setText("Du : ");
		
		beginDate = new Label(grpDatesDeLoacation, SWT.NONE);
		beginDate.setText("19/09/2014");
		
		Label lblAu = new Label(grpDatesDeLoacation, SWT.NONE);
		lblAu.setText("Au : ");
		lblAu.setBounds(0, 0, 24, 15);
		
		endDate = new Label(grpDatesDeLoacation, SWT.NONE);
		endDate.setText("19/09/2014");
		endDate.setBounds(0, 0, 58, 15);
		setRental( RentalCoreActivator.getAgency().getRentals().get(0));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	public void setRental( Rental r)
	{
		rentedObjetLabel.setText(r.getRentedObject().getName());
		customerLabel.setText(r.getCustomer().getDisplayName());
		beginDate.setText(r.getStartDate().toString());
		endDate.setText(r.getEndDate().toString());
	}

}
