package com.sogeti.rental.ui.views;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sogeti.rental.core.RentalCoreActivator;
import com.sogeti.rental.ui.RentalUiActivator;

public class RentalAgencyView extends ViewPart implements IPropertyChangeListener {

	private TreeViewer agencyViewer;

	public RentalAgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		agencyViewer = new TreeViewer( parent);
		
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
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		RentalUiActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	};

	public void dispose() {
		super.dispose();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		agencyViewer.refresh();
	};
	

}
