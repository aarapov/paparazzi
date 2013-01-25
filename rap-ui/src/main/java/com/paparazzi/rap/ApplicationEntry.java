package com.paparazzi.rap;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box.Filler;

import org.eclipse.rwt.RWT;
import org.eclipse.rwt.lifecycle.IEntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class ApplicationEntry implements IEntryPoint {

    private java.util.List<Player> players;

    public ApplicationEntry() {
        players = new ArrayList<Player>();
        players.add(new Player("Roger Federer", "Switzerland", 1));
        players.add(new Player("Rafael Nadal", "Spain", 2));
        players.add(new Player("Andy Roddick", "USA", 3));
        players.add(new Player("Lleyton Hewitt", "Australia", 4));
        players.add(new Player("Nikolay Davydenko", "Russia", 5));
        players.add(new Player("David Nalbandian", "ARG", 6));
        players.add(new Player("Andre Agassi", "USA", 7));
        players.add(new Player("Guillermo Coria", "ARG", 8));
    }
    
    @Override
    public int createUI() {
        
        Display display = new Display();
        Shell mainShell = new Shell(display, SWT.TITLE);
        mainShell.setText("RAP Maven Demo");
        mainShell.setMaximized(true);
        mainShell.setLayout(new GridLayout(1, true));
        RWT.getBrowserHistory().createEntry("myAnchor", "mainApp");
        Composite top = createTopPanel(mainShell);
        top.setLayout(new FillLayout(SWT.HORIZONTAL));

        Button button1 = new Button(top, SWT.PUSH);
        button1.setText("Button 1");
        Button button2 = new Button(top, SWT.PUSH);
        button2.setText("Button 2");

        Composite content = createContentPanel(mainShell);
        content.setLayout(new FillLayout(SWT.HORIZONTAL));
        createContent(content);

        mainShell.layout();
        mainShell.open();
        return 0;
    }

    private Composite createTopPanel(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        data.horizontalSpan = 1;
        data.verticalSpan = 2;
        composite.setLayoutData(data);

        return composite;
    }

    private Composite createContentPanel(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment  = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        data.grabExcessVerticalSpace = true;
        data.horizontalSpan = 1;
        data.verticalSpan = 10;
        composite.setLayoutData(data);

        return composite;
    }

    private void createMenu(Shell composite) {
        
        Menu menu = new Menu(composite, SWT.BAR);
        MenuItem menuItem = new MenuItem(menu, SWT.NONE);
        menuItem.setText("Print Element");
    }
    
    private void createContent(Composite composite) {
        final Table table = new Table(composite, SWT.NONE);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        TableColumn[] column = new TableColumn[3];
        column[0] = new TableColumn(table, SWT.NONE);
        column[0].setText("Name");
        
        column[1] = new TableColumn(table, SWT.NONE);
        column[1].setText("Country");
        
        column[2] = new TableColumn(table, SWT.RIGHT);
        column[2].setText("Ranking");
        
        fillTable(table);
        for (int i = 0, n = column.length; i < n; i++) {
            column[i].pack();
        }
    }
    
    private void fillTable(Table table) {
        table.setRedraw(false);
       
        for(Iterator iterator = players.iterator();iterator.hasNext();){
            Player player = (Player) iterator.next();
            TableItem item = new TableItem(table, SWT.NONE);
            int c = 0;
            item.setText(c++, player.getName());
            item.setText(c++, player.getCountry());
            item.setText(c++, String.valueOf(player.getRanking()));
        }
        table.setRedraw(true);
    }

    class Player {
        private String name;
        private String country;
        private int ranking;

        public Player(String name, String country, int ranking) {
            this.name = name;
            this.country = country;
            this.ranking = ranking;
        }

        public int getRanking() {
            return ranking;
        }
        public String getName() {
            return name;
        }
        public String getCountry() {
            return country;
        }
    }
}
