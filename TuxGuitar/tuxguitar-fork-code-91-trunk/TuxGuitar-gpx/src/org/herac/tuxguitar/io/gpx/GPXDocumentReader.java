package org.herac.tuxguitar.io.gpx;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.herac.tuxguitar.io.gpx.score.GPXAutomation;
import org.herac.tuxguitar.io.gpx.score.GPXBar;
import org.herac.tuxguitar.io.gpx.score.GPXBeat;
import org.herac.tuxguitar.io.gpx.score.GPXDocument;
import org.herac.tuxguitar.io.gpx.score.GPXMasterBar;
import org.herac.tuxguitar.io.gpx.score.GPXNote;
import org.herac.tuxguitar.io.gpx.score.GPXRhythm;
import org.herac.tuxguitar.io.gpx.score.GPXTrack;
import org.herac.tuxguitar.io.gpx.score.GPXVoice;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class GPXDocumentReader {
	
	private Document xmlDocument;
	private GPXDocument gpxDocument;
	
	public GPXDocumentReader(InputStream stream){
		this.xmlDocument = getDocument(stream);
		this.gpxDocument = new GPXDocument();
		// debug
		DOMImplementationLS domImplLS = (DOMImplementationLS) this.xmlDocument
		    .getImplementation();
		LSSerializer serializer = domImplLS.createLSSerializer();
		String str = serializer.writeToString(this.xmlDocument);
		System.out.println(str);
	}
	
	private Document getDocument(InputStream stream) {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(stream);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return null;
	}
	
	public GPXDocument read(){
		if( this.xmlDocument != null ){
			this.readScore();
			this.readAutomations();
			this.readTracks();
			this.readMasterBars();
			this.readBars();
			this.readVoices();
			this.readBeats();
			this.readNotes();
			this.readRhythms();
		}
		return this.gpxDocument;
	}
	
	public void readScore(){
		if( this.xmlDocument != null ){
			Node scoreNode = getChildNode(this.xmlDocument.getFirstChild(), "Score");
			if( scoreNode != null ){
				this.gpxDocument.getScore().setTitle( getChildNodeContent(scoreNode, "Title"));
				this.gpxDocument.getScore().setSubTitle( getChildNodeContent(scoreNode, "SubTitle"));
				this.gpxDocument.getScore().setArtist( getChildNodeContent(scoreNode, "Artist"));
				this.gpxDocument.getScore().setAlbum( getChildNodeContent(scoreNode, "Album"));
				this.gpxDocument.getScore().setWords( getChildNodeContent(scoreNode, "Words"));
				this.gpxDocument.getScore().setMusic( getChildNodeContent(scoreNode, "Music"));
				this.gpxDocument.getScore().setWordsAndMusic( getChildNodeContent(scoreNode, "WordsAndMusic"));
				this.gpxDocument.getScore().setCopyright( getChildNodeContent(scoreNode, "Copyright"));
				this.gpxDocument.getScore().setTabber( getChildNodeContent(scoreNode, "Tabber"));
				this.gpxDocument.getScore().setInstructions( getChildNodeContent(scoreNode, "Instructions"));
				this.gpxDocument.getScore().setNotices( getChildNodeContent(scoreNode, "Notices"));
			}
		}
	}
	
	public void readAutomations(){
		if( this.xmlDocument != null ){
			Node masterTrackNode = getChildNode(this.xmlDocument.getFirstChild(), "MasterTrack");
			if( masterTrackNode != null ){
				NodeList automationNodes = getChildNodeList(masterTrackNode, "Automations");
				for( int i = 0 ; i < automationNodes.getLength() ; i ++ ){
					Node automationNode = automationNodes.item( i );
					if( automationNode.getNodeName().equals("Automation") ){
						GPXAutomation automation = new GPXAutomation();
						automation.setType( getChildNodeContent(automationNode, "Type"));
						automation.setBarId( getChildNodeIntegerContent(automationNode, "Bar"));
						automation.setValue( getChildNodeIntegerContentArray(automationNode, "Value"));
						automation.setLinear( getChildNodeBooleanContent(automationNode, "Linear"));
						automation.setPosition( getChildNodeIntegerContent(automationNode, "Position"));
						automation.setVisible( getChildNodeBooleanContent(automationNode, "Visible"));
						
						this.gpxDocument.getAutomations().add( automation );
					}
				}
			}
		}
	}
	
	public void readTracks(){
		if( this.xmlDocument != null ){
			NodeList trackNodes = getChildNodeList(this.xmlDocument.getFirstChild(), "Tracks");
			for( int i = 0 ; i < trackNodes.getLength() ; i ++ ){
				Node trackNode = trackNodes.item( i );
				if( trackNode.getNodeName().equals("Track") ){
					GPXTrack track = new GPXTrack();
					track.setId( getAttributeIntegerValue(trackNode, "id") );
					track.setName(getChildNodeContent(trackNode, "Name" ));
					track.setColor(getChildNodeIntegerContentArray(trackNode, "Color"));
					Node gmNode = getChildNode(trackNode, "GeneralMidi");
					if( gmNode != null ){
						track.setGmProgram(getChildNodeIntegerContent(gmNode, "Program"));
						track.setGmChannel1(getChildNodeIntegerContent(gmNode, "PrimaryChannel"));
						track.setGmChannel2(getChildNodeIntegerContent(gmNode, "SecondaryChannel"));
					}
					
					NodeList propertyNodes = getChildNodeList(trackNode, "Properties");
					if( propertyNodes != null ){
						for( int p = 0 ; p < propertyNodes.getLength() ; p ++ ){
							Node propertyNode = propertyNodes.item( p );
							if (propertyNode.getNodeName().equals("Property") ){ 
								if( getAttributeValue(propertyNode, "name").equals("Tuning") ){
									track.setTunningPitches( getChildNodeIntegerContentArray(propertyNode, "Pitches") );
								}
							}
						}
					}
					this.gpxDocument.getTracks().add( track );
				}
			}
		}
	}
	
	public void readMasterBars(){
		if( this.xmlDocument != null ){
			NodeList masterBarNodes = getChildNodeList(this.xmlDocument.getFirstChild(), "MasterBars");
			for( int i = 0 ; i < masterBarNodes.getLength() ; i ++ ){
				Node masterBarNode = masterBarNodes.item( i );
				if( masterBarNode.getNodeName().equals("MasterBar") ){
					GPXMasterBar masterBar = new GPXMasterBar();
					masterBar.setBarIds( getChildNodeIntegerContentArray(masterBarNode, "Bars"));
					masterBar.setTime( getChildNodeIntegerContentArray(masterBarNode, "Time", "/"));
					
					Node repeatNode = getChildNode(masterBarNode, "Repeat");
					if( repeatNode != null ){
						masterBar.setRepeatStart(getAttributeBooleanValue(repeatNode, "start"));
						if( getAttributeBooleanValue(repeatNode, "end") ){
							masterBar.setRepeatCount( getAttributeIntegerValue(repeatNode, "count"));
						}
					}
					this.gpxDocument.getMasterBars().add( masterBar );
				}
			}
		}
	}
	
	public void readBars(){
		if( this.xmlDocument != null ){
			NodeList barNodes = getChildNodeList(this.xmlDocument.getFirstChild(), "Bars");
			for( int i = 0 ; i < barNodes.getLength() ; i ++ ){
				Node barNode = barNodes.item( i );
				if( barNode.getNodeName().equals("Bar") ){
					GPXBar bar = new GPXBar();
					bar.setId(getAttributeIntegerValue(barNode, "id"));
					bar.setVoiceIds( getChildNodeIntegerContentArray(barNode, "Voices"));
					bar.setClef(getChildNodeContent(barNode, "Clef"));
					bar.setSimileMark(getChildNodeContent(barNode,"SimileMark"));
					
					this.gpxDocument.getBars().add( bar );
				}
			}
		}
	}
	
	public void readVoices(){
		if( this.xmlDocument != null ){
			NodeList voiceNodes = getChildNodeList(this.xmlDocument.getFirstChild(), "Voices");
			for( int i = 0 ; i < voiceNodes.getLength() ; i ++ ){
				Node voiceNode = voiceNodes.item( i );
				if( voiceNode.getNodeName().equals("Voice") ){
					GPXVoice voice = new GPXVoice();
					voice.setId(getAttributeIntegerValue(voiceNode, "id"));
					voice.setBeatIds( getChildNodeIntegerContentArray(voiceNode, "Beats"));
					
					this.gpxDocument.getVoices().add( voice );
				}
			}
		}
	}
	
	public void readBeats(){
		if( this.xmlDocument != null ){
			NodeList beatNodes = getChildNodeList(this.xmlDocument.getFirstChild(), "Beats");
			for( int i = 0 ; i < beatNodes.getLength() ; i ++ ){
				Node beatNode = beatNodes.item( i );
				if( beatNode.getNodeName().equals("Beat") ){
					GPXBeat beat = new GPXBeat();
					beat.setId(getAttributeIntegerValue(beatNode, "id"));
					beat.setDynamic(getChildNodeContent(beatNode, "Dynamic"));
					beat.setRhythmId(getAttributeIntegerValue(getChildNode(beatNode, "Rhythm"), "ref"));
					beat.setNoteIds( getChildNodeIntegerContentArray(beatNode, "Notes"));
					// TODO: <Legato destination="false" origin="true"/>
					// TODO: <Hairpin>Crescendo</Hairpin>
					this.gpxDocument.getBeats().add( beat );
				}
			}
		}
	}
	
	public void readNotes(){
		if( this.xmlDocument != null ){
			NodeList noteNodes = getChildNodeList(this.xmlDocument.getFirstChild(), "Notes");
			for( int i = 0 ; i < noteNodes.getLength() ; i ++ ){
				Node noteNode = noteNodes.item( i );
				if( noteNode.getNodeName().equals("Note") ){
					GPXNote note = new GPXNote();
					note.setId( getAttributeIntegerValue(noteNode, "id") );
					
					Node tieNode = getChildNode(noteNode, "Tie");
					note.setTieDestination( tieNode != null ? getAttributeValue(tieNode, "destination").equals("true") : false);
					
					note.setVibrato( getChildNode(noteNode, "Vibrato") != null );
					
					// TODO:
					// note.setAccent( getChildNodeIntegerContent(propertyNode, "Accent") ); // 0 if it doesn't exist
					// not parsed: <Accidental>Sharp</Accidental>

					NodeList propertyNodes = getChildNodeList(noteNode, "Properties");
					for( int p = 0 ; p < propertyNodes.getLength() ; p ++ ){
						Node propertyNode = propertyNodes.item( p );
						if (propertyNode.getNodeName().equals("Property") ){ 
							String propertyName = getAttributeValue(propertyNode, "name");
							if( propertyName.equals("String") ){
								note.setString( getChildNodeIntegerContent(propertyNode, "String") );
							}
							if( propertyName.equals("Fret") ){
								note.setFret( getChildNodeIntegerContent(propertyNode, "Fret") );
							}
							if( propertyName.equals("Midi") ){
								note.setMidiNumber( getChildNodeIntegerContent(propertyNode, "Number") );
							}
							if( propertyName.equals("Tone") ){
								note.setTone( getChildNodeIntegerContent(propertyNode, "Step") );
							}
							if( propertyName.equals("Octave") ){
								note.setOctave( getChildNodeIntegerContent(propertyNode, "Number") );
							}
							if( propertyName.equals("Element") ){
								note.setElement( getChildNodeIntegerContent(propertyNode, "Element") );
							}
							if( propertyName.equals("Variation") ){
								note.setVariation( getChildNodeIntegerContent(propertyNode, "Variation") );
							}
							if( propertyName.equals("Muted") ){
								note.setMutedEnabled( getChildNode(propertyNode, "Enable") != null );
							}
							if( propertyName.equals("PalmMuted") ){
								note.setPalmMutedEnabled( getChildNode(propertyNode, "Enable") != null );
							}
							if( propertyName.equals("Slide") ){
								note.setSlide( true );
								note.setSlideFlags( getChildNodeIntegerContent(propertyNode, "Flags") );
							}
							if( propertyName.equals("Tapped") ){
								note.setTapped( getChildNode(propertyNode, "Enable") != null );
							}
							if( propertyName.equals("Bended") ){
								note.setBendEnabled( getChildNode(propertyNode, "Enable") != null );
							}
							if( propertyName.equals("BendOriginValue") ){
								note.setBendOriginValue( getChildNodeIntegerContent(propertyNode, "Float") );
							}
							if( propertyName.equals("BendMiddleValue") ){
								note.setBendMiddleValue( getChildNodeIntegerContent(propertyNode, "Float") );
							}
							if( propertyName.equals("BendDestinationValue") ){
								note.setBendDestinationValue( getChildNodeIntegerContent(propertyNode, "Float") );
							}
							if( propertyName.equals("HopoOrigin") ){
								note.setHammer(true);
							}
							if( propertyName.equals("HopoDestination") ){
//								this is a hammer-on or pull-off
							}
							if( propertyName.equals("HarmonicFret") ){
								note.setHarmonicFret( ( getChildNodeIntegerContent(propertyNode, "HFret") ) );
							}
							if( propertyName.equals("HarmonicType") ){
								note.setHarmonicType( getChildNodeContent (propertyNode, "HType"));
							}
							/*
TODO:
WhammyBar
WhammyBarDestinationValue
WhammyBarExtend
WhammyBarMiddleValue
WhammyBarOriginValue
							*/
						}
					}
					
					this.gpxDocument.getNotes().add( note );
				}
			}
		}
	}
	
	public void readRhythms(){
		if( this.xmlDocument != null ){
			NodeList rhythmNodes = getChildNodeList(this.xmlDocument.getFirstChild(), "Rhythms");
			for( int i = 0 ; i < rhythmNodes.getLength() ; i ++ ){
				Node rhythmNode = rhythmNodes.item( i );
				if( rhythmNode.getNodeName().equals("Rhythm") ){
					Node primaryTupletNode = getChildNode(rhythmNode, "PrimaryTuplet");
					Node augmentationDotNode = getChildNode(rhythmNode, "AugmentationDot");
					
					GPXRhythm rhythm = new GPXRhythm();
					rhythm.setId( getAttributeIntegerValue(rhythmNode, "id") );
					rhythm.setNoteValue(getChildNodeContent(rhythmNode, "NoteValue") );
					rhythm.setPrimaryTupletDen(primaryTupletNode != null ? getAttributeIntegerValue(primaryTupletNode, "den") : 1);
					rhythm.setPrimaryTupletNum(primaryTupletNode != null ? getAttributeIntegerValue(primaryTupletNode, "num") : 1);
					rhythm.setAugmentationDotCount(augmentationDotNode != null ? getAttributeIntegerValue(augmentationDotNode, "count") : 0);
					
					this.gpxDocument.getRhythms().add( rhythm );
				}
			}
		}
	}
	
	private String getAttributeValue(Node node, String attribute ){
		if( node != null ){
			return node.getAttributes().getNamedItem( attribute ).getNodeValue();
		}
		return null;
	}
	
	private int getAttributeIntegerValue(Node node, String attribute ){
		try {
			return Integer.parseInt(this.getAttributeValue(node, attribute));
		} catch( Throwable throwable ){ 
			return 0;
		}
	}
	
	private boolean getAttributeBooleanValue(Node node, String attribute ){
		String value = this.getAttributeValue(node, attribute);
		if( value != null ){
			return value.equals("true");
		}
		return false;
	}
	
	private Node getChildNode(Node node, String name ){
		NodeList childNodes = node.getChildNodes();
		for( int i = 0 ; i < childNodes.getLength() ; i ++ ){
			Node childNode = childNodes.item( i );
			if( childNode.getNodeName().equals( name ) ){
				return childNode;
			}
		}
		return null;
	}
	
	private NodeList getChildNodeList(Node node, String name ){
		Node childNode = getChildNode(node, name);
		if( childNode != null ){
			return childNode.getChildNodes();
		}
		return null;
	}
	
	private String getChildNodeContent(Node node, String name ){
		Node childNode = getChildNode(node, name);
		if( childNode != null ){
			return childNode.getTextContent();
		}
		return null;
	}
	
	private boolean getChildNodeBooleanContent(Node node, String name ){
		String value = this.getChildNodeContent(node, name);
		if( value != null ){
			return value.equals("true");
		}
		return false;
	}
	
	private int getChildNodeIntegerContent(Node node, String name ){
		try {
			return Integer.parseInt(this.getChildNodeContent(node, name));
		} catch( Throwable throwable ){
			return 0;
		}
	}
	
	private int[] getChildNodeIntegerContentArray(Node node, String name , String regex){
		try {
			String[] contents = ( this.getChildNodeContent(node, name).trim().split(regex) );
			int[] intContents = new int[contents.length];
			for( int i = 0 ; i < intContents.length; i ++ ){
				intContents[i] = Integer.parseInt( contents[i].trim() );
			}
			return intContents;
		} catch( Throwable throwable ){
			return null;
		}
	}
	
	private int[] getChildNodeIntegerContentArray(Node node, String name ){
		return getChildNodeIntegerContentArray(node, name, (" ") );
	}
}
