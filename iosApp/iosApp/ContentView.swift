import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    let rootComponent: RootComponent
    let storageRepository: StorageRepository
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(
            rootComponent: rootComponent,
            storageRepository: storageRepository
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
