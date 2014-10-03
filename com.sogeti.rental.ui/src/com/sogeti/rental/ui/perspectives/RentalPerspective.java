package com.sogeti.rental.ui.perspectives;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class RentalPerspective implements IPerspectiveFactory {

	public static final String   ID     = "com.sogeti.rental.ui.perspectives.RentalPerspective";
	
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		String editorArea = layout.getEditorArea();
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		layout.addView("com.sogeti.rental.ui.RentalAgencyView", IPageLayout.LEFT, 0.48f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("com.sogeti.rental.ui.rentalPropertyView", IPageLayout.BOTTOM, 0.5f, "com.sogeti.rental.ui.RentalAgencyView");
		layout.addView("com.sogeti.rental.ui.views.CustomerView", IPageLayout.RIGHT, 0.5f, "com.sogeti.rental.ui.rentalPropertyView");
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}
