package se.liu.antwe841.tetris;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TetrisViewer {
    private Board board;
    private TetrisComponent tetrisComponent;
    private JMenuBar menuBar;
    private JFrame frame = new JFrame("Tetris");
    private StartImageShower startImage = new StartImageShower();
    private ScoreComponent scoreComponent;
    private GameRunner gameRunner;

    public TetrisViewer(BoardTester boardTester) {
	this.board = boardTester.getBoard();
	this.tetrisComponent = new TetrisComponent(board);
	this.menuBar = new JMenuBar();
	this.scoreComponent = new ScoreComponent(board);
	this.gameRunner = boardTester.getGameRunner();
    }

    // ================================================ Getters ============================================================================


    public TetrisComponent getTetrisComponent() {
	return tetrisComponent;
    }

    public ScoreComponent getScoreComponent() {
	return scoreComponent;
    }

    // ============================================= Public methods ========================================================================


    public void show() {
	setUpFrame();
	setUpMenu();
	frame.pack();
	frame.setVisible(true);
    }

    public void setStartIMG(){
	frame.add(startImage);
	frame.pack();
	frame.setVisible(true);
    }

    public void setBoard(){
        setUpFrame();
        frame.remove(startImage);
    }

    // ============================================= Private methods =======================================================================


    private void setUpMenu(){
	JMenu game = new JMenu("Game");
	final JMenuItem quit = new JMenuItem("Quit");
	final JMenuItem restart = new JMenuItem("Restart");
	game.add(quit);
	game.add(restart);
	menuBar.add(game);
	quit.addActionListener(new MenuAction(MenuChoice.QUIT));
	restart.addActionListener(new MenuAction(MenuChoice.RESTART));
    }

    private void setUpFrame(){
	frame.setLayout(new BorderLayout());
	frame.add(tetrisComponent, BorderLayout.CENTER);
	frame.add(scoreComponent, BorderLayout.SOUTH);
	frame.setJMenuBar(menuBar);
	makeKeyStrokeActions(frame.getRootPane());
    }

    private void saveScore(){
	String name = JOptionPane.showInputDialog("Name");
	Highscore highscore = new Highscore(name, board.getTotalScore());
	gameRunner.getHighscoreList().addScore(highscore);
	List<Highscore> scores = gameRunner.getHighscoreList().getHighScoreList();
	scores.sort(new ScoreComparator());
    }

    private void makeKeyStrokeActions(JComponent pane) {
	final InputMap in = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
	in.put(KeyStroke.getKeyStroke("UP"), "rotateRight");
	in.put(KeyStroke.getKeyStroke("DOWN"), "rotateLeft");
	in.put(KeyStroke.getKeyStroke("SPACE"), "down");

	final ActionMap act = pane.getActionMap();
	act.put("moveLeft", new MoveAction(Direction.LEFT));
	act.put("moveRight", new MoveAction(Direction.RIGHT));
	act.put("down", new MoveAction(Direction.DOWN));

	act.put("rotateLeft", new RotateAction(Direction.LEFT));
	act.put("rotateRight", new RotateAction(Direction.RIGHT));
    }

    // ============================================= Private classes =======================================================================


    private class MoveAction extends AbstractAction {
	private final Direction moveCommand;

	private MoveAction(final Direction moveCommand) {
	    this.moveCommand = moveCommand;
	}

	@Override public void actionPerformed(final ActionEvent e) {
	    board.move(moveCommand);
	    if (board.hasCollision(board.getFalling())) {
		if (moveCommand.equals(Direction.LEFT)) {
		    board.move(Direction.RIGHT);
		}
		else if (moveCommand.equals(Direction.RIGHT)){
		    board.move(Direction.LEFT);
		}
		else if (moveCommand.equals(Direction.DOWN)){
		    board.move(Direction.UP);
		}
	    }
	}
    }

    private class RotateAction extends AbstractAction {
	private final Direction rotateCommand;

	private RotateAction(final Direction rotateCommand) {
	    this.rotateCommand = rotateCommand;
	}

	@Override public void actionPerformed(final ActionEvent e) {
	    board.rotate(rotateCommand);
	}
    }


    private class MenuAction extends AbstractAction {
	private final MenuChoice choice;
	private final static String QUIT_MESSAGE = "Are you sure you want to quit?";

	private MenuAction(final MenuChoice action) {
	    this.choice = action;
	}


	@Override public void actionPerformed(final ActionEvent e) {
	    switch (choice) {
		case QUIT:
		    if (JOptionPane.showConfirmDialog(null, QUIT_MESSAGE, "",
						      JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			saveScore();
			JOptionPane.showMessageDialog(null, gameRunner.getHighscoreList().getHighScoreList().toString());
			Gson gson = new Gson();
			String listAsJson = gson.toJson(gameRunner.getHighscoreList());
			System.out.println(listAsJson);
			System.exit(0);
		    }
		    break;
		case RESTART:
		    saveScore();
		    frame.dispose();
		    JOptionPane.showMessageDialog(null, gameRunner.getHighscoreList().getHighScoreList().toString());
		    gameRunner.newGame(gameRunner);
		    break;
		default:
		    System.out.println("deafult");
	    }
	}
    }
}
