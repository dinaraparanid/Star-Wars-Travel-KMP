import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    var controllerArgs = KodeinIOS.shared.initializeWithControllerArgs()
    
	var body: some Scene {
		WindowGroup {
            ComposeView(
                rootComponent: controllerArgs.rootComponent,
                themeProvider: controllerArgs.themeProvider
            ).ignoresSafeArea(.keyboard)
		}
	}
}
