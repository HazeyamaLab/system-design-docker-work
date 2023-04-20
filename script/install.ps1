[string]$log='
_____________________________________________________________________________
____________________________________________________####__####___#####___#___
__##___________#######_____#########_______##_____________#__#___________#___
____##_______________#_____________________#________####__#__#___#####___#___
__________#__________#_____________________#______________#__#_#_________#___
_##______##_________#______##########_____##________####_#___##___####_######
__###____#__________#__________##_________#___##_________________________#___
________##_________#___________#__________#____#____####__#####___####___#___
_______##_________###__________#_________#______#_________#__#___________#___
______##_________#___#_________#_________#______#___#__#___#_#___##__#___#___
___###_________##_____#_______#_________##########__#__#___##____#___#___#___
_###__________#________#____##___________________#__####__##_#___#####___#___
____________________________________________________#____#____#__#_______#___
_____________________________________________________________________________
Copyright (c) 2023 "Tokyo Gakugei University - Hazeyamalab"
'
Write-Host "$log"

function Install-GUI-Application-By-Scoop {
    scoop install vscode
  }
function Init-Scoop {
    scoop bucket add extras
  }

if (gcm scoop -ea SilentlyContinue) {
    Write-Host "[1/4] scoop is already installed! skipping this step."
  } else {
    $env:SCOOP='C:\Scoop'
    [environment]::setEnvironmentVariable('SCOOP', $env:SCOOP,'User')
    Write-Host "[1/4] installing scoop..."
    iex "& {$(irm get.scoop.sh)} -RunAsAdmin"
  }

  if (gcm git -ea SilentlyContinue) {
    Write-Host "[2/4] git is already installed! skipping this step."
  } else {
    Write-Host "[2/4] installing git..."
    scoop install git
  }

  if (gcm scoop -and gcm choco -ea SilentlyContinue) {
    Write-Host "[3/4] installing vscode"
    Init-Scoop
    Install-GUI-Application-By-Scoop
    Write-Host "[4/4] installing ubuntu"
    wsl --install -d Ubuntu
  } else {
    [string]$err='
    [ERROR] command not found! The installation procedure may have changed.
    See the chocolatey documentation.
      https://chocolatey.org/install
    See the scoop documentation.
      https://scoop.sh/
    '
    $Host.UI.WriteErrorLine("$err")
    exit 1
  }

