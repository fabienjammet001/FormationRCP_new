package com.sogeti.rental.ui.views;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;
import com.sogeti.rental.ui.RentalUiActivator;

public class RentalCustomerView extends ViewPart implements ISelectionListener {

	private Label customerLabel;

	public RentalCustomerView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		// TODO Auto-generated method stub

		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setText("INFORMATIONS");
		infoGroup.setLayout(new GridLayout(1, false));


		customerLabel = new Label(infoGroup, SWT.NONE);
		customerLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		customerLabel.setText("John Wayne");

		DragSource ds = new DragSource(customerLabel, DND.DROP_COPY);
		ds.setTransfer(new Transfer[] { TextTransfer.getInstance() });
		ds.addDragListener(new DragSourceAdapter() {
			public void dragSetData(DragSourceEvent event) {
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = customerLabel.getText();
				}
			}

			@Override
			public void dragStart(DragSourceEvent event) {
				event.image = RentalUiActivator.getDefault().getImageRegistry()
						.get(RentalUIConstants.ICONS_AGENCY);
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void setCustomer(Customer r) {
		customerLabel.setText(r.getDisplayName());
	}

	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		site.getPage().addSelectionListener(this);
	};

	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		super.dispose();
	};

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if ( selection.isEmpty() )
		{
			return ;
		}
		else
		{
			if (selection instanceof IStructuredSelection) {
				Object selected = ((IStructuredSelection) selection).getFirstElement();
				if ( selected != null)
				{
					Customer c = (Customer) Platform.getAdapterManager().getAdapter(selected, Customer.class);
					if ( c != null)
						setCustomer( c );
				}
			}
		}

	}

}
