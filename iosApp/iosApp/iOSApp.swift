import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            ComposeView(rootComponent: KoinIOS.shared.initializeWithRootComponent())
                .ignoresSafeArea(.keyboard)
		}
	}
}
