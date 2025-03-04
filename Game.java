package termProject;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Game {
	private Player player;
	private Player computer;
	private boolean playerTurn;
	private DeckImage deck;
	
	
	public Game () {
		player = new Player("User");
		computer = new Player ("Computer");
		playerTurn = true;
		deck = new DeckImage();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getComputer() {
		return computer;
	}

	public void setComputer(Player computer) {
		this.computer = computer;
	}

	public boolean isPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}

	public DeckImage getDeck() {
		return deck;
	}

	public void setDeck(DeckImage deck) {
		this.deck = deck;
	}
	
	public boolean checkIfOver(Player player) {
		String message ="";
		if (player.getPoints() >= 33) {
			JOptionPane.showMessageDialog(null, "Game Over! " + player.getName() + " has lost!");
			int option = JOptionPane.showConfirmDialog(null, message + "\nDo you want to restart the game?", "Game Over", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
		    	deck = new DeckImage();
		        return true;
		    } else {
		        System.exit(0); // Close the application
		        return false;
		    }
			
		}
		return false;
 
	}
	
	public void dealCardToUser(JButton button, JLabel total) {
		int cardValue = deck.getImage();
		button.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/termProject/pictures/"+cardValue+".png")).getImage().getScaledInstance(196, 262, Image.SCALE_SMOOTH)));
	    player.addPoints(cardValue);
	    total.setText("User Total: " + player.getPoints());
	    deck.delete();
	    //checkIfOver(player);
	}
	
	public void dealCardToComputer(JLabel label, JLabel total) {
		if (!computerShouldSkip()) {
		int cardValue = deck.getImage();
		label.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/termProject/pictures/"+cardValue+".png")).getImage().getScaledInstance(196, 262, Image.SCALE_SMOOTH)));
	    computer.addPoints(cardValue);
	    total.setText("Computer Total: " + computer.getPoints());
	    deck.delete();
	   // checkIfOver(computer);
		}
	}
	
	public boolean checkWin() {
		String message = "";
		
			if (player.getPoints() > computer.getPoints()) {
				JOptionPane.showMessageDialog(null, "Game Over! " + computer.getName() + " has won!");
			}
			else if (player.getPoints() < computer.getPoints()) {
				JOptionPane.showMessageDialog(null, "Game Over! " + player.getName() + " has won!");
			}
			else {
				JOptionPane.showMessageDialog(null, "It is a Tie!");
			}
			
			int option = JOptionPane.showConfirmDialog(null, message + "\nDo you want to restart the game?", "Game Over", JOptionPane.YES_NO_OPTION);
		    
		    if (option == JOptionPane.YES_OPTION) {
		    	deck = new DeckImage();
		        return true;
		    } else {
		        System.exit(0); // Close the application
		        return false;
		    }
	}

	public boolean computerShouldSkip() {
		int x = 0;
		if(computer.getPoints() >= 29) {
			x =(int)(Math.random()*4);
				if (x <= 2) {
					JOptionPane.showMessageDialog(null, "Computer has Skipped!");
					return true;
				}
				else {
					return false;
				}
		}
		else if(computer.getPoints() >= 25) {
			x =(int)(Math.random()*3);
			if (x <= 1) {
				JOptionPane.showMessageDialog(null, "Computer has Skipped!");
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	
}