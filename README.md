Mica — Geo Capture Camera Application ID: com.terrastamp.geocamera MicaStamp is a professional geotagged camera, inspection, 
and survey application built for Android and Web. It captures location-verified field photos with real-time GPS telemetry overlays,
offline Open Location Codes (Plus Codes), embedded EXIF metadata, and automated street address resolution. 🌟 Key Features

📷 Precision Telemetry Stamping • Live GPS Telemetry: Captures Latitude & Longitude (Decimal Degrees DD and Degrees-Minutes-Seconds DMS),
Altitude (m and ft), Compass Heading (cardinal direction + degrees), Horizontal Accuracy (±m), and Timestamp. • Visual Watermark Overlay: 
Customizable on-camera watermark stamp (Top Bar, Bottom Bar, or Rounded Badge). • EXIF Metadata: Encodes standard GPS EXIF metadata
directly into the JPEG image headers for seamless compatibility with GIS tools (QGIS, ArcGIS, Google Earth).
📡 Offline GPS & Automatic Re-Sync • Satellite GPS Lock: Works 100% offline in remote areas without cellular or Wi-Fi connectivity. •
Offline Plus Codes: Calculates Google Plus Codes (e.g., 7Q54PX7M+QW) offline. • Background Auto-Sync: When internet connectivity is
restored, photos taken offline automatically reverse geocode to resolve full street addresses (Road, Barangay/District, City, Province, 
Country) and update photo stamps in IndexedDB.
🖼️ Multi-Aspect Ratio Viewfinder Supports 4 standard camera aspect ratios: • 4:3 (Standard Camera) • 16:9 (Widescreen) • 1:1 (Square) • 3:2 (4R) 
(Standard 4" × 6" Photo Print Size) Includes Rule-of-Thirds survey grid, front/rear camera toggle, flash, and 3-second self-timer.
📁 Native Android Gallery Integration • Includes a custom native Java plugin (MediaGalleryPlugin) that saves captured geotagged JPEGs directly to your 
device's public Pictures/MicaStamp folder via Android MediaStore so photos immediately appear in Google Photos, Samsung Gallery, and device file managers.
📊 Inspection & Export Suite • Photo Inspector Modal: Compare stamped vs. raw original frames, add observation notes, or open coordinates directly in
Google Maps. • Live Map View: Interactive Google Maps interface plotting all geotagged photos. • Multi-Format Exports: ◦ Geotagged EXIF JPEGs ◦ 
GeoJSON (for QGIS / ArcGIS) ◦ CSV Survey Logs (for Excel / Spreadsheets) ◦ Printable HTML Field Reports 🛠️ Tech Stack • Frontend: React 19, TypeScript, 
Tailwind CSS, Lucide React, Vite, Workbox PWA. • Mobile Runtime: Capacitor 8 (Android Platform). • Native Android: Java (MediaGalleryPlugin, MediaStore integration, BridgeActivity). • Backend Proxy: Express, Node.js (Google Maps Reverse Geocoding & Elevation API). 🚀 Getting Started Prerequisites • Node.js (v20 or higher) • Android Studio (Ladybug or newer with Android SDK & Gradle installed)
Installation npm install
Run Web App Locally npm run dev Open http://localhost:3000 in your browser. 📱 Building & Deploying to Android
Build Web Assets & Sync to Android npm run build Copy the compiled dist directory into Android assets, or sync via Capacitor: npm run android:sync
Open in Android Studio & Run npm run android:open Or open Android Studio and choose File → Open → /android.
Wait for Gradle sync to complete. 2. Select your connected Android device or Emulator. 3. Click Run ▶ (Shift + F10) to build, deploy, 
and launch MicaStamp on your device. 🔒 Permissions & Security • Camera (android.permission.CAMERA): For live viewfinder and photo capture. • 
Location (android.permission.ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION): For GPS telemetry acquisition. • Storage 
(android.permission.WRITE_EXTERNAL_STORAGE, READ_MEDIA_IMAGES): For saving photos to the public Pictures/MicaStamp album. 📄 License Private / Proprietary — 
MicaStamp Geo Capture System.
