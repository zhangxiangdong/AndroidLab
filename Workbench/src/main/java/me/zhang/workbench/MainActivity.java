package me.zhang.workbench;

import me.zhang.workbench.animation.AnimateLayoutChangesActivity;
import me.zhang.workbench.animation.CardFlipActivity;
import me.zhang.workbench.animation.LogoWhiteAnimActivity;
import me.zhang.workbench.base.MenuActivity;
import me.zhang.workbench.gestures.GesturesActivity;
import me.zhang.workbench.layout.LayoutActivity;
import me.zhang.workbench.view.VisibilityActivity;
import me.zhang.workbench.webview.WebViewActivity;

public class MainActivity extends MenuActivity {

    @Override
    protected void prepareMenu() {
        addMenuItem("Layout", LayoutActivity.class);
        addMenuItem("WebView", WebViewActivity.class);
        addMenuItem("GesturesActivity", GesturesActivity.class);
        addMenuItem("Visibility", VisibilityActivity.class);
        addMenuItem("Card Flip", CardFlipActivity.class);
        addMenuItem("Animate Layout Changes", AnimateLayoutChangesActivity.class);
        addMenuItem("I/O Logo White Animation", LogoWhiteAnimActivity.class);
    }

}
