import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    let rootComponent: RootComponent
    let themeProvider: ThemeProvider
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(
            rootComponent: rootComponent,
            themeProvider: themeProvider
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
