package com.sogeti.rental.rcp;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.sogeti.rental.ui.perspectives.RentalPerspective;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	//private static final String PERSPECTIVE_ID = "com.sogeti.rental.rcp.perspective"; //$NON-NLS-1$

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	public String getInitialWindowPerspectiveId() {
		return RentalPerspective.ID;
	}
}
