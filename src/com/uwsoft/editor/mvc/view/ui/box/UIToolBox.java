/*
 * ******************************************************************************
 *  * Copyright 2015 See AUTHORS file.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *****************************************************************************
 */

package com.uwsoft.editor.mvc.view.ui.box;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.kotcrab.vis.ui.widget.VisImageButton;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisWindow;
import com.uwsoft.editor.mvc.Overlap2DFacade;
import com.uwsoft.editor.mvc.proxy.TextureManager;

public class UIToolBox extends VisWindow {
    private static final int ALIGN_TOP = 0;
    public static final String ALIGN_TOP_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_TOP;
    private static final int ALIGN_LEFT = 1;
    public static final String ALIGN_LEFT_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_LEFT;
    private static final int ALIGN_BOTTOM = 2;
    public static final String ALIGN_BOTTOM_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_BOTTOM;
    private static final int ALIGN_RIGHT = 3;
    public static final String ALIGN_RIGHT_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_RIGHT;
    private static final int ALIGN_CENTER_LEFT = 4;
    public static final String ALIGN_CENTER_LEFT_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_CENTER_LEFT;
    private static final int ALIGN_CENTER_BOTTOM = 5;
    public static final String ALIGN_CENTER_BOTTOM_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_CENTER_BOTTOM;
    //
    private static final int ALIGN_AT_EDGE_TOP = 6;
    public static final String ALIGN_AT_EDGE_TOP_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_AT_EDGE_TOP;
    private static final int ALIGN_AT_EDGE_LEFT = 7;
    public static final String ALIGN_AT_EDGE_LEFT_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_AT_EDGE_LEFT;
    private static final int ALIGN_AT_EDGE_BOTTOM = 8;
    public static final String ALIGN_AT_EDGE_BOTTOM_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_AT_EDGE_BOTTOM;
    private static final int ALIGN_AT_EDGE_RIGHT = 9;
    public static final String ALIGN_AT_EDGE_RIGHT_BTN_CLICKED = "com.uwsoft.editor.mvc.view.ui.box.UIToolBox.ALIGN_" + ALIGN_AT_EDGE_RIGHT;
    //
    private final Overlap2DFacade faced;
    private final TextureManager textureManager;
//    private final Overlap2DFacade facade;
//    private final TextureManager textureManager;
//    private ButtonGroup btnGroup;
//
//    private final static int maxRows = 2;
//    private final static int maxCols = 6;
//
//    private int currRow = 0;
//    private int currCol = 0;

    public UIToolBox() {
        super("Toolbox", true);
        faced = Overlap2DFacade.getInstance();
        textureManager = faced.retrieveProxy(TextureManager.NAME);
        VisTable mainTable = new VisTable();
        mainTable.add(new VisImageButton(getDrawable("mainIcon"))).padRight(2).padBottom(2);
        mainTable.add(new VisImageButton(getDrawable("resizeIcon"))).padRight(2).padBottom(2);
        //
        mainTable.add(createAlignmentButton("alignIconL", ALIGN_TOP)).padRight(2).padBottom(2);
        mainTable.add(createAlignmentButton("alignIconL", ALIGN_LEFT)).padRight(2).padBottom(2);
        mainTable.add(createAlignmentButton("alignIconL", ALIGN_BOTTOM)).padRight(2).padBottom(2);
        mainTable.add(createAlignmentButton("alignIconL", ALIGN_RIGHT));
        //
        mainTable.row();
        mainTable.add(createAlignmentButton("alignIconCH", ALIGN_CENTER_LEFT)).padRight(2);
        mainTable.add(createAlignmentButton("alignIconCH", ALIGN_CENTER_BOTTOM)).padRight(2);
        mainTable.add(createAlignmentButton("AlignEdge", ALIGN_AT_EDGE_LEFT)).padRight(2);
        mainTable.add(createAlignmentButton("AlignEdge", ALIGN_AT_EDGE_TOP)).padRight(2);
        mainTable.add(createAlignmentButton("AlignEdge", ALIGN_AT_EDGE_RIGHT)).padRight(2);
        mainTable.add(createAlignmentButton("AlignEdge", ALIGN_AT_EDGE_BOTTOM));
        //
        add(mainTable);
    }

    private TextureRegionDrawable getDrawable(String name) {
        return new TextureRegionDrawable(textureManager.getEditorAsset(name));
    }

    private VisImageButton createAlignmentButton(String name, int alignment) {
        VisImageButton visImageButton = new VisImageButton(getDrawable(name));
        visImageButton.addListener(new AlignmentButtonClickListener(alignment));
        return visImageButton;
    }

    private class AlignmentButtonClickListener extends ClickListener {

        private final int alignment;

        public AlignmentButtonClickListener(int alignment) {
            this.alignment = alignment;
        }

        @Override
        public void clicked(InputEvent event, float x, float y) {
            super.clicked(event, x, y);
            String notification = "";
            switch (alignment) {
                case ALIGN_TOP:
                    notification = ALIGN_TOP_BTN_CLICKED;
                    break;
                case ALIGN_LEFT:
                    notification = ALIGN_LEFT_BTN_CLICKED;
                    break;
                case ALIGN_BOTTOM:
                    notification = ALIGN_BOTTOM_BTN_CLICKED;
                    break;
                case ALIGN_RIGHT:
                    notification = ALIGN_RIGHT_BTN_CLICKED;
                    break;
                case ALIGN_CENTER_LEFT:
                    notification = ALIGN_CENTER_LEFT_BTN_CLICKED;
                    break;
                case ALIGN_CENTER_BOTTOM:
                    notification = ALIGN_CENTER_BOTTOM_BTN_CLICKED;
                    break;
                case ALIGN_AT_EDGE_TOP:
                    notification = ALIGN_AT_EDGE_TOP_BTN_CLICKED;
                    break;
                case ALIGN_AT_EDGE_LEFT:
                    notification = ALIGN_AT_EDGE_LEFT_BTN_CLICKED;
                    break;
                case ALIGN_AT_EDGE_BOTTOM:
                    notification = ALIGN_AT_EDGE_BOTTOM_BTN_CLICKED;
                    break;
                case ALIGN_AT_EDGE_RIGHT:
                    notification = ALIGN_AT_EDGE_RIGHT_BTN_CLICKED;
                    break;
            }
            Overlap2DFacade facade = Overlap2DFacade.getInstance();
            facade.sendNotification(notification);
        }
    }

}
