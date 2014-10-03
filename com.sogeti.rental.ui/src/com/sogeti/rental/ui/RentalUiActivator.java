package com.sogeti.rental.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorDecorator;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.sogeti.rental.ui.views.RentalUIConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUiActivator extends AbstractUIPlugin implements
		RentalUIConstants {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sogeti.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUiActivator plugin;
	private Map<String, Palette> paletteManager = new HashMap<String, Palette>();

	/**
	 * The constructor
	 */
	public RentalUiActivator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		readViewExtensions();
	}

	private void readViewExtensions() {

		IExtensionRegistry reg = Platform.getExtensionRegistry();
		for (IConfigurationElement e : reg.getConfigurationElementsFor("com.sogeti.rental.ui.palette")) {
			try {
				Palette p = new Palette();
				p.setId(e.getAttribute("id"));
				p.setName(e.getAttribute("name"));

				p.setProvider((IColorProvider) e
						.createExecutableExtension("class"));

				paletteManager.put(p.getId(), p);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public Map<String, Palette> getPaletteManager() {
		return paletteManager;
	}

	public void setPaletteManager(Map<String, Palette> paletteManager) {
		this.paletteManager = paletteManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
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
		reg.put(ICONS_CUSTOMERS,
				ImageDescriptor.createFromURL(b.getEntry(ICONS_CUSTOMERS)));
		reg.put(ICONS_AGENCY,
				ImageDescriptor.createFromURL(b.getEntry(ICONS_AGENCY)));
		reg.put(ICONS_RENTALS,
				ImageDescriptor.createFromURL(b.getEntry(ICONS_RENTALS)));
		reg.put(ICONS_RENTALS_OBJECTS, ImageDescriptor.createFromURL(b
				.getEntry(ICONS_RENTALS_OBJECTS)));
	}

}
