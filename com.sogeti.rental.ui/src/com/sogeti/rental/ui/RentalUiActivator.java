package com.sogeti.rental.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.sogeti.rental.ui.views.RentalUIConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUiActivator extends AbstractUIPlugin implements RentalUIConstants {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sogeti.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUiActivator plugin;
	
	/**
	 * The constructor
	 */
	public RentalUiActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RentalUiActivator getDefault() {
		return plugin;
	}
    protected void initializeImageRegistry(ImageRegistry reg) {
        
    	Bundle b = FrameworkUtil.getBundle(getClass());
    	reg.put(ICONS_CUSTOMERS, ImageDescriptor.createFromURL(b.getEntry(ICONS_CUSTOMERS)));
    	reg.put(ICONS_AGENCY, ImageDescriptor.createFromURL(b.getEntry(ICONS_AGENCY)));
    	reg.put(ICONS_RENTALS, ImageDescriptor.createFromURL(b.getEntry(ICONS_RENTALS)));
    	reg.put(ICONS_RENTALS_OBJECTS, ImageDescriptor.createFromURL(b.getEntry(ICONS_RENTALS_OBJECTS)));
    }

}
