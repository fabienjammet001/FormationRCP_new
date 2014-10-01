package com.sogeti.rental.ui.views;

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

import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;
import com.sogeti.rental.ui.RentalUiActivator;

public class RentalPropertyView extends ViewPart implements ISelectionListener {

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

		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setText("INFORMATIONS");
		infoGroup.setLayout(new GridLayout(2, false));

		rentedObjetLabel = new Label(infoGroup, SWT.NONE);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjetLabel.setLayoutData(gd);

		Label lblNewLabel_1 = new Label(infoGroup, SWT.NONE);
		lblNewLabel_1.setText("Lou\u00E9 \u00E0 : ");

		customerLabel = new Label(infoGroup, SWT.NONE);
		customerLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
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
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
		DragSource ds = new DragSource(rentedObjetLabel, DND.DROP_COPY);
		ds.setTransfer(new Transfer[] { TextTransfer.getInstance() });
		ds.addDragListener(new DragSourceAdapter() {
			public void dragSetData(DragSourceEvent event) {
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = rentedObjetLabel.getText();
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

	public void setRental(Rental r) {
		rentedObjetLabel.setText(r.getRentedObject().getName());
		customerLabel.setText(r.getCustomer().getDisplayName());
		beginDate.setText(r.getStartDate().toString());
		endDate.setText(r.getEndDate().toString());
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
		if (selection instanceof IStructuredSelection) {
			Object selected = ((IStructuredSelection) selection)
					.getFirstElement();
			if (selected instanceof Rental)
				setRental((Rental) selected);
		}

	}

}
