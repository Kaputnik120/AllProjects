package org.herac.tuxguitar.gui.actions.transport;

import org.eclipse.swt.events.TypedEvent;
import org.herac.tuxguitar.gui.TuxGuitar;
import org.herac.tuxguitar.gui.actions.Action;
import org.herac.tuxguitar.player.base.MidiPlayerMode;
import org.herac.tuxguitar.song.models.TGMeasure;

public class TransportSetLoopEHeaderAction extends Action {
	
	public static final String NAME = "action.transport.set-loop-end";
	
	public TransportSetLoopEHeaderAction() {
		super(NAME, AUTO_LOCK | AUTO_UNLOCK | AUTO_UPDATE | KEY_BINDING_AVAILABLE);
	}
	
	protected int execute(TypedEvent e){
		TGMeasure measure = getEditor().getTablature().getCaret().getMeasure();
		if( measure != null ){
			MidiPlayerMode pm = TuxGuitar.instance().getPlayer().getMode();
			if( pm.isLoop() ){
				pm.setLoopEHeader( pm.getLoopEHeader() != measure.getNumber() ? measure.getNumber() : -1 );
			}
		}
		return 0;
	}
}
