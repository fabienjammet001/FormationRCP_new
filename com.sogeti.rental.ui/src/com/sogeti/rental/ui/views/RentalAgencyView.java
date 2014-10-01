package com.sogeti.rental.ui.views;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sogeti.rental.core.RentalCoreActivator;

public class RentalAgencyView extends ViewPart {

	public RentalAgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		TreeViewer agencyViewer = new TreeViewer( parent);
		
		Collection<RentalAgency> agencies = new ArrayList<RentalAgency>();
		agencies.add(RentalCoreActivator.getAgency());
		RentalProvider provider = new RentalProvider();
		agencyViewer.setContentProvider( provider);
		agencyViewer.setLabelProvider( provider);
		agencyViewer.setInput( agencies );
		getSite().setSelectionProvider(agencyViewer);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
