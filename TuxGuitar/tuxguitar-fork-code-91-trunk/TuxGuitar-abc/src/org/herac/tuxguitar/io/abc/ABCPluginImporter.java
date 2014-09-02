package org.herac.tuxguitar.io.abc;

import org.herac.tuxguitar.gui.system.plugins.base.TGImporterPlugin;
import org.herac.tuxguitar.io.base.TGRawImporter;

public class ABCPluginImporter extends TGImporterPlugin{
	
	protected TGRawImporter getImporter() {
		return new ABCSongImporter();
	}
	
	public String getAuthor() {
		return "Peter Grootswagers <pgrootswagers@planet.nl>";
	}
	
	public String getName() {
		return "ABCF file format importer";
	}
	
	public String getDescription() {
		return "ABCF file format importer";
	}
	
	public String getVersion() {
		return "1.0";
	}
}
